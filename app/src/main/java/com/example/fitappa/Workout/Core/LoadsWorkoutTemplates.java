package com.example.fitappa.Workout.Core;

import java.util.List;

public interface LoadsWorkoutTemplates {
    /**
     * Load templates from the gateway and attempt to add a workout template to it
     *
     * @param workoutTemplates List of WorkoutTemplate which is retrieved from the gateway
     */
    void loadWorkoutTemplates(List<WorkoutTemplate> workoutTemplates);

}
