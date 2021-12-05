package com.example.fitappa.Workout.Core;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;
import com.example.fitappa.Workout.CRUD.AddWorkoutPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkoutTemplatesGateway implements Loadable, Saveable {
    private final DocumentReference documentReference;
    private final AddWorkoutPresenter presenter;
    private final String routineName;

    public WorkoutTemplatesGateway(AddWorkoutPresenter presenter, String routineName)
    {

        this.routineName = routineName;

        this.presenter = presenter;
        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseConstants constants = new DatabaseConstants();

        // get the document reference for the current user
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    @Override
    public void load() {

    }

    @Override
    public void save(Object o) {
        // init
        WorkoutTemplates templates = new WorkoutTemplates();

        //noinspection rawtypes
        for (Object object : (List) o) {
            templates.add((WorkoutTemplate) object);
        }

        //documentReference.update("wo")
    }

    // Defines a way to retrieve data from firebase and cast to a List<WorkoutTemplates>
    private static class WorkoutTemplates implements Serializable {
        private final List<WorkoutTemplate> workoutTemplates;


        /**
         * Constructor needed to be public for firebase to cast List into Routines
         * Initialize list of workoutTemplates to ArrayList
         */
        public WorkoutTemplates() {
            workoutTemplates = new ArrayList<>();
        }

        /**
         * Method required to be public for Firebase.
         * Gets the workout templates list from this instance.
         *
         * @return List of workout templates
         */
        public List<WorkoutTemplate> getWorkoutTemplates() {
            return workoutTemplates;
        }

        private void add(WorkoutTemplate template) {
            workoutTemplates.add(template);
        }
    }
}
