package com.example.fitappa.Routine;

import android.util.Log;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
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

    /**
     * Constructor used when needing to load routines from a database and call a method
     * from presenter to use them
     *
     * @param presenter StartWorkoutPresenter that allows the program to use the routines
     */
    public RoutinesGateway(LoadsRoutines presenter) {
        this.presenter = presenter;

        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseConstants constants = new DatabaseConstants();

        // get the document reference for the current user
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
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
                        Map<String, List<Map<String, Object>>> routinesMap = (Map<String, List<Map<String, Object>>>) documentSnapshot.get("routines");

                        // Loop through the man and add each routine to the Routines object
                        for (Object routineName : Objects.requireNonNull(routinesMap).keySet()) {
                            Routine routine = new Routine((String) routineName);

                            List<Map<String, Object>> workoutTemplateMap = (List<Map<String, Object>>) routinesMap.get(routineName);

                            List<WorkoutTemplate> workoutTemplates = new ArrayList<>();
                            for (Map<String, Object> map : Objects.requireNonNull(workoutTemplateMap)) {
                                WorkoutTemplate tempWorkoutTemplate = new WorkoutTemplate((String) map.get("name"), (List<ExerciseTemplate>) map.get("exercises"));
                                workoutTemplates.add(tempWorkoutTemplate);
                            }

                            routine.setWorkouts(workoutTemplates);
                            routines.add(routine);
                        }

                        // pass the retrieved routines object in List<Routine> format to the presenter
                        presenter.loadRoutines(routines.routineList());

                    } catch (RuntimeException e) {
                        // If the database fails to retrieve list of routines, pass an empty arraylist
                        presenter.loadRoutines(new ArrayList<>());
                    }
                });
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
        documentReference.update("routines", routines.getRoutines());
    }


    // Defines a way to retrieve data from firebase and cast to a List<Routine>
    private static class Routines implements Serializable {
        private final Map<String, List<WorkoutTemplate>> routines;


        /**
         * Constructor needed to be public for firebase to cast List into Routines
         * Initialize list of routines to empty ArrayList
         */
        public Routines() {
            routines = new HashMap<>();
        }

        /**
         * Method required to be public for Firebase.
         * Gets the routines list from this instance.
         *
         * @return List of Routine
         */
        public Map<String, List<WorkoutTemplate>> getRoutines() {
            return routines;
        }

        private List<Routine> routineList() {
            List<Routine> routineList = new ArrayList<>();
            for (String name : routines.keySet()) {
                Routine newRoutine = new Routine(name);
                newRoutine.setWorkouts(routines.get(name));
                routineList.add(newRoutine);
            }

            return routineList;
        }

        private void add(Routine routine) {
            routines.put(routine.getName(), routine.getWorkouts());
        }
    }
}
