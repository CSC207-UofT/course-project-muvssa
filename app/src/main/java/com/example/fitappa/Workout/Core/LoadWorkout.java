package com.example.fitappa.Workout.Core;

import java.util.List;

/**
 * This interface ensures we can load back the saved workouts
 */
public interface LoadWorkout {
    /**
     * Load all PerformWorkout by username
     * @param username the username to load the workouts for
     * @return a list of PerformWorkout
     */
    List<PerformWorkout> loadPerformedWorkouts(String username);
}
