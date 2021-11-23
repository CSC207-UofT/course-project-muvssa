package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.WeightedRepExercise;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ExerciseRepository {
    private final View view;


    /**
     * Constructor that takes in a View interface (defined within this class) and initializes it
     *
     * @param view View interface
     */
    public ExerciseRepository(View view) {
        this.view = view;
    }

    /**
     * Retrieves all exercises from remote database and sets the exercises field to them.
     */
    public void retrieveExercises() {
        FirebaseFirestore mAuth = FirebaseFirestore.getInstance();

        mAuth.collection("exercises")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    // Initialize arraylist of empty exercises
                    List<Exercise> exercises = new ArrayList<>();
                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        Exercise exercise = new WeightedRepExercise((String) document.get("name"));
                        // Add each retrieved exercise to list
                        exercises.add(exercise);
                    }
                    // Pass list of exercises to view to load
                    view.loadExercise(exercises);
                });
    }

    /**
     * Dependency Inversion.
     * <p>
     * To be implemented by ViewWorkoutActivity so that this class can load the exercises there.
     */
    public interface View {
        /**
         * This method loads all the Workout's exercises and updates it in the
         * ExerciseLayout view component.
         *
         * @param exercises represents the Exercise objects stored in the Workout
         */
        void loadExercise(List<Exercise> exercises);
    }
}
