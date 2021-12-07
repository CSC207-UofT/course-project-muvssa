package com.example.fitappa.workout.workout_template;

import java.util.List;

/**
 * This interface ensures that the specific workout templates loads
 *
 * Methods in this class load a specific workout templates
 *
 * Documentation specifies what the methods do
 *
 * @author Abdullah
 *
 * @since 0.2
 */


interface LoadsWorkoutTemplates {
    /**
     * Load templates from the gateway and attempt to add a workout template to it
     *
     * @param workoutTemplates List of WorkoutTemplate which is retrieved from the gateway
     */
    void loadWorkoutTemplates(List<WorkoutTemplate> workoutTemplates);

}
