package com.example.fitappa.Exercise;

/**
 * A Set represents set of an exercise repetitions in a workout.
 * This is a general set and should be used for exercises like
 * skipping ropes, jumping jacks, and etc. Exercises where there is
 * not much work being done.
 */
public class Set implements Settable {
    protected double numReps;

    /**
     * This method creates a Set object
     * @param numReps
     */
    public Set(double numReps) {
        // numReps must be 0 for all newly created sets
        this.numReps = numReps;
    }

    /**
     * This method sets the number of reps to numReps
     * @param numReps the number of reps
     */
    public void completeSet(double numReps) {
        this.numReps = numReps;
    }

    /**
     * This method indicates if this set is complete / finished.
     * @return true iff this.numReps != 0
     */
    public boolean isComplete() {
        return this.numReps != 0;
    }


    /**
     * Volume is quantitative measure of the work done.
     * In the case of a general set, the volume is always 0
     * @return
     */
    public double volume() {
        return 0;
    }

}
