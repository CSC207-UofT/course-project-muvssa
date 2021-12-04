package com.example.fitappa.Exercise.Exercise;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as a gateway between database & ExerciseTemplates
 *
 * The methods move the data between database and the ExerciseTemplates
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Uthman
 * @author Abdullah
 * @version 0.1
 */
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
        DatabaseConstants constants = new DatabaseConstants();

        // Get the collection reference to exercises from firebase
        CollectionReference exerciseCollection = FirebaseFirestore.getInstance()
                .collection(constants.getExercisesCollection());

        exerciseCollection.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    // Initialize arraylist of empty exercises
                    List<ExerciseTemplate> exerciseTemplates = new ArrayList<>();
                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        // Create exercise object to be retrieved
                        ExerciseTemplate exerciseTemplate = document.toObject(ExerciseTemplate.class);

                        // Add each retrieved exercise to list
                        exerciseTemplates.add(exerciseTemplate);
                    }

                    // Pass list of exercises to view to load
                    view.loadExercise(exerciseTemplates);
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
         * @param exerciseTemplates represents the Exercise objects stored in the Workout
         */
        void loadExercise(List<ExerciseTemplate> exerciseTemplates);
    }
}
