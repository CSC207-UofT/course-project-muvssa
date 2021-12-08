package com.example.fitappa.exercise.set;

import androidx.annotation.NonNull;

/**
 * A Set represents set of an exercise repetitions in a workout.
 * This is a general set and should be used for exercises like
 * skipping ropes, jumping jacks, and etc. Exercises where there is
 * not much work being done.
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 */
public class RepSet implements Set {
    protected final double numReps;

    /**
     * This method creates a Set object
     * @param numReps represents the number of reps
     */
    public RepSet(double numReps) {
        // numReps must be 0 for all newly created sets
        this.numReps = numReps;
    }

    @NonNull
    @Override
    public String toString() {
        return "Reps: " + this.numReps + "";
    }
}
