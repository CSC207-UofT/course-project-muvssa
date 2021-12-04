package com.example.fitappa.Workout.Core;

/**
 * This interface ensures that the performed workouts can be saved in database
 *
 * The database must have a table of the following form
 *     id | username | performedWorkout
 *
 *  where   id is any integer to support sequencing,
 *          username is the username of the user who performed this workout
 *          performedWorkout object
 *
 */
public interface SaveWorkout {
    /**
     * This method creates adds the row described above into the database table
     */
    void save();
}
