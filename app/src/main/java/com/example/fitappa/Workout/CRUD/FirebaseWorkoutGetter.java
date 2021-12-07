package com.example.fitappa.Workout.CRUD;

import androidx.annotation.NonNull;

import com.example.fitappa.Exercise.Exercise.Category;
import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.example.fitappa.constants.DatabaseConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class gets a users workouts from the database
 *
 * Methods in this class pull information from the database
 *
 * Documentation specifies what the methods do
 *
 * @author Abdullah
 *
 * @since 0.5
 */

public class FirebaseWorkoutGetter {
    private final String routineName;
    private final DatabaseConstants constants;

    public FirebaseWorkoutGetter(String routineName) {
        this.routineName = routineName;
        this.constants = new DatabaseConstants();
    }

    /**
     * Accesses the document snapshot from firebase and retrieves the list of workout templates
     *
     * @param documentSnapshot DocumentSnapshot object from firebase to be casted to retrieve data
     * @return List of WorkoutTemplate representing the workout templates for a specific routine
     */
    @NonNull
    public List<WorkoutTemplate> getWorkoutTemplates(com.google.firebase.firestore.DocumentSnapshot
                                                             documentSnapshot) {
        // Get object representing list of routines
        @SuppressWarnings("unchecked")
        Map<String, List<Map<String, Object>>> routineMap =
                (Map<String, List<Map<String, Object>>>) documentSnapshot
                        .get(constants.getRoutines());

        // Get object representing a routine
        List<Map<String, Object>> workoutTemplateList =
                Objects.requireNonNull(routineMap).get(routineName);

        // initialize workout templates
        List<WorkoutTemplate> workoutTemplates = new ArrayList<>();

        // Loop through the workout templates object and input workout templates to the list
        for (Map<String, Object> workoutMap : Objects.requireNonNull(workoutTemplateList)) {
            WorkoutTemplate workoutTemplate = getWorkoutTemplate(workoutMap);
            workoutTemplates.add(workoutTemplate);
        }

        return workoutTemplates;
    }

    /**
     * Get the workout template from a map representing a workoutTemplate
     *
     * @param workoutTemplateMap Map of String to Object representing a workout template
     * @return a WorkoutTemplate object constructor from the map received
     */
    @NonNull
    private WorkoutTemplate getWorkoutTemplate(Map<String, Object> workoutTemplateMap) {
        // Get the workout's name
        String workoutName = (String) workoutTemplateMap.get(constants.getName());

        // Get object representing the exercise templates list
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> exerciseTemplatesList =
                (List<Map<String, Object>>) workoutTemplateMap.get(constants.getExercises());

        List<ExerciseTemplate> exerciseTemplates = new ArrayList<>();
        // Loop through and create the exerciseTemplates list
        for (Map<String, Object> exerciseMap : Objects.requireNonNull(exerciseTemplatesList)) {
            String name = (String) exerciseMap.get(constants.getName());
            Integer sets = (Integer) exerciseMap.get(constants.getSets());
            String categoryString = (String) exerciseMap.get(constants.getCategory());
            Category category = Category.valueOf(categoryString);

            // Add each exerciseTemplate to the list
            ExerciseTemplate exerciseTemplate =
                    new ExerciseTemplate(name, integerToInt(sets), category);
            exerciseTemplates.add(exerciseTemplate);
        }

        // Create the WorkoutTemplate object and add it to the workoutTemplates list
        return new WorkoutTemplate(workoutName, exerciseTemplates);
    }

    /**
     * Convert an Integer object to int by returning 0 if the Integer given is null
     *
     * @param integer Integer object to be returned as int
     * @return int representing the Integer converted to int
     */
    private int integerToInt(Integer integer) {
        if (integer == null) {
            return 0;
        } else {
            return integer;
        }
    }
}
