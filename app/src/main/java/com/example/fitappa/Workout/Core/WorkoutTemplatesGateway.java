package com.example.fitappa.Workout.Core;

import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.CRUD.FirebaseWorkoutGetter;
import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Gateway class for WorkoutTemplate that implements Loadable and Saveable so it can load and save
 * workout templates from the database.
 *
 * @author Uthman
 * @layer Gateway (Third)
 * @since 0.5
 */
public class WorkoutTemplatesGateway implements Loadable, Saveable {
    private final DocumentReference documentReference;
    private final LoadsWorkoutTemplates presenter;
    private final String routineName;
    private final DatabaseConstants constants;

    /**
     * Constructor that takes in an interface LoadsWorkoutTemplates so that it can present
     * the retrieved data from the load method and a routine name to save and load workout
     * templates from and to a specific routine
     *
     * @param presenter   LoadsWorkoutTemplates interface that is implemented by a presenter
     * @param routineName String representing the specific routine's name to access
     */
    public WorkoutTemplatesGateway(LoadsWorkoutTemplates presenter, String routineName) {

        this.routineName = routineName;

        this.presenter = presenter;
        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        constants = new DatabaseConstants();

        // get the document reference for the current user
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * load in workout templates from the database for the current user logged in
     */
    @Override
    public void load() {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            try {

                FirebaseWorkoutGetter firebaseWorkoutGetter = new FirebaseWorkoutGetter(routineName);
                List<WorkoutTemplate> workoutTemplates = firebaseWorkoutGetter.getWorkoutTemplates(documentSnapshot);

                // pass the retrieved workout templates to the presenter
                presenter.loadWorkoutTemplates(workoutTemplates);

            } catch (RuntimeException e) {
                // If there is a failure from the database, pass in an empty list
                presenter.loadWorkoutTemplates(new ArrayList<>());
            }
        });
    }


    /**
     * Save workout templates into the database for the current user with a specific routine
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        // init
        List<WorkoutTemplate> workoutTemplates = new ArrayList<>();

        //noinspection rawtypes
        for (Object object : (List) o) {
            workoutTemplates.add((WorkoutTemplate) object);
        }

        // Update the routine with the workoutTemplates
        // String is using dot notation to access the specific routine.
        // Ex. "routine.name" which would get the specific routine
        documentReference.update(constants.getRoutines() + "." + routineName, workoutTemplates);
    }
}
