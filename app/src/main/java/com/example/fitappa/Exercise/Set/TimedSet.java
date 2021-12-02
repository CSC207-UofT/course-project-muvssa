package com.example.fitappa.Exercise.Set;

/**
 * A TimedSet is another way to track progress through an exercises.
 * It uses time (in seconds) as its measure
 */
public class TimedSet implements Settable {
    private double time;


    /**
     * Starts an empty set that uses time as its measure.
     */
    public TimedSet() {
        this.time = 0;
    }

    /**
     * Builds a completed set that uses time as its measure
     * @param time
     */
    public TimedSet(double time) {
        this.time = time;
    }

    /**
     * TODO: Javadoc
     * @param time
     */
    public void completeSet(double time) {
        this.time = time;
    }

    /**
     * TODO: Javadoc
     * @return
     */
    public double getTime() {
        return this.time;
    }

    /**
     * The volume for a timed set is always 0
     * @return volume for a timed set
     */
    @Override
    public double volume() {
        return 0;
    }

    /**
     *
     * @return True iff time != 0
     */
    @Override
    public boolean isComplete() {
        return time != 0;
    }

}
