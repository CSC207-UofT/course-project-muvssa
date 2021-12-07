package com.example.fitappa.Routine;

import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.CRUD.FirebaseWorkoutGetter;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Gateway class for Routines that implements Loadable and Saveable so it can load and save
 * routines from the database.
 *
 * @author Uthman
 * @layer Gateway (Third)
 * @since 0.5
 */
public class RoutinesGateway implements Loadable, Saveable {

    private final DocumentReference documentReference;
    private final LoadsRoutines presenter;
    private final DatabaseConstants constants;

    /**
     * Constructor used when needing to load routines from a database and call a method
     * from presenter to use them
     *
     * @param presenter StartWorkoutPresenter that allows the program to use the routines
     */
    public RoutinesGateway(LoadsRoutines presenter) {
        this.presenter = presenter;
        this.constants = new DatabaseConstants();

        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseConstants constants = new DatabaseConstants();

        // get the document reference for the current user
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsers())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * load in routines from the database for the current user logged in
     */
    @Override
    public void load() {
        documentReference
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    Routines routines = new Routines();
                    try {
                        @SuppressWarnings("unchecked")
                        Map<String, List<Map<String, Object>>> routinesMap =
                                (Map<String, List<Map<String, Object>>>) documentSnapshot
                                        .get(constants.getRoutines());

                        fillRoutinesWithMap(routines, routinesMap, documentSnapshot);

                        // pass the retrieved routines object in List<Routine> format to presenter
                        presenter.loadRoutines(routines.routineList());

                    } catch (RuntimeException e) {
                        // If database fails to retrieve list of routines, pass an empty arraylist
                        presenter.loadRoutines(new ArrayList<>());
                    }
                });
    }

    /**
     * Fill the given routines object with Routine objects inside the routinesMap
     *
     * @param routines         Routines object with a map of routines
     * @param routinesMap      Map of routines taken from firebase
     * @param documentSnapshot DocumentSnapshot firebase object needed for firebase use case
     */
    private void fillRoutinesWithMap(Routines routines,
                                     Map<String, List<Map<String, Object>>> routinesMap,
                                     DocumentSnapshot documentSnapshot) {
        // Loop through the man and add each routine to the Routines object
        for (Object routineNameObject : Objects.requireNonNull(routinesMap).keySet()) {
            String routineName = (String) routineNameObject;
            Routine routine = new Routine(routineName);

            FirebaseWorkoutGetter firebaseWorkoutGetter = new FirebaseWorkoutGetter(routineName);
            List<WorkoutTemplate> workoutTemplates =
                    firebaseWorkoutGetter.getWorkoutTemplates(documentSnapshot);

            routine.setWorkouts(workoutTemplates);
            routines.add(routine);
        }
    }

    /**
     * Save routines into the database for the current user
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        // Initialize Routines object to pass in appropriate format
        Routines routines = new Routines();
        //noinspection rawtypes
        for (Object object : (List) o) {
            routines.add((Routine) object);
        }

        // Add the routines to the database
        documentReference.update(constants.getRoutines(), routines.getRoutines());
    }


    // Defines a way to retrieve data from firebase and cast to a List<Routine>
    private static class Routines implements Serializable {
        private final Map<String, List<WorkoutTemplate>> routines;


        /**
         * Initialize list of routines to empty ArrayList
         */
        private Routines() {
            routines = new HashMap<>();
        }

        /**
         * Gets the routines list from this instance.
         *
         * @return Map from String to List of WorkoutTemplate
         */
        private Map<String, List<WorkoutTemplate>> getRoutines() {
            return routines;
        }

        /**
         * Convert the Map routines into a List<Routine> format and return it
         *
         * @return List of Routine objects
         */
        private List<Routine> routineList() {
            List<Routine> routineList = new ArrayList<>();
            for (String name : routines.keySet()) {
                Routine newRoutine = new Routine(name);
                newRoutine.setWorkouts(routines.get(name));
                routineList.add(newRoutine);
            }

            return routineList;
        }

        /**
         * Add a routine to the map
         *
         * @param routine Routine to be added to routines map
         */
        private void add(Routine routine) {
            routines.put(routine.getName(), routine.getWorkouts());
        }
    }
}
