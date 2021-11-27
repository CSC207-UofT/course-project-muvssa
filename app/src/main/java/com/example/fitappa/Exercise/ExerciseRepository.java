package com.example.fitappa.Exercise;

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
        // Get the instance of firebase
        FirebaseFirestore mAuth = FirebaseFirestore.getInstance();

        mAuth.collection("exercises")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    // Initialize arraylist of empty exercises
                    List<Exercise> exercises = new ArrayList<>();
                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        // Create exercise object to be retrieved
                        Exercise exercise = getExerciseFromDocument(document);

                        // Add each retrieved exercise to list
                        exercises.add(exercise);
                    }

                    // Pass list of exercises to view to load
                    view.loadExercise(exercises);
                });
    }

    /**
     * Create an Exercise object given a DocumentSnapshot from firebase. Do this by checking the type
     * of each document and creating an appropriate Exercise object.
     *
     * @param document DocumentSnapshot retrieved from firebase
     * @return Exercise object created from fields inside document
     */
    private Exercise getExerciseFromDocument(DocumentSnapshot document) {
        // Create exercise object to be initialized
        Exercise exercise;

        // Get Exercise universal parameters
        String name = (String) document.get("name");
        int numSets = objectToInt(document.get("numSets"));
        int numRest = objectToInt(document.get("numRest"));
        String muscleGroup = (String) document.get("muscleGroup");

        // Check to see what type of Exercise this is
        if (document.contains("weight")) {
            // Get variables needed for WeightedRepExercise object
            int numReps = objectToInt(document.get("numReps"));
            double weight = objectToDouble(document.get("weight"));
            exercise = new WeightedRepExercise(name, numSets, numRest, muscleGroup, numReps, weight);
        } else if (document.contains("numReps")) {
            // Get variables needed for RepExercise object
            int numReps = objectToInt(document.get("numReps"));
            exercise = new RepExercise(name, numSets, numRest, muscleGroup, numReps);
        } else {
            // Get variables needed for TimedExercise object
            int setTime = objectToInt(document.get("setTime"));
            exercise = new TimedExercise(name, numSets, numRest, muscleGroup, setTime);
        }

        return exercise;
    }

    /**
     * Return an int given an Object
     * <p>
     * Strictly used for firebase data retrieval.
     * <p>
     * Precondition: Object passed in must be of type Long
     *
     * @param o Object which will be converted
     * @return int converted from the given Object o
     */
    private int objectToInt(Object o) {
        if (o != null) {
            Long l = (Long) o;
            return l.intValue();
        }

        return 0;
    }

    /**
     * Return a double given an Object
     * <p>
     * Strictly used for firebase data retrieval.
     * <p>
     * Precondition: Object passed in must be of type double
     *
     * @param o Object which will be converted
     * @return double converted from the given Object o
     */
    private double objectToDouble(Object o) {
        if (o != null) {
            return (double) o;
        }

        return 0;
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
