package com.example.fitappa.Exercise.Set;

/**
 * A TimedSet is another way to track progress through an exercises.
 * It uses time (in seconds) as its measure
 *
 * The methods help initialize what a timed set should be
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 *
 * @since 0.2
 */
public class TimedSet implements Set {
    private final double time;


    /**
     * Builds a completed set that uses time as its measure
     * @param time the time taken to complete the set
     */
    public TimedSet(double time) {
        this.time = time;
    }

    /**
     * This method return the time it took to finish this set
     * @return the time taken to complete the set
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
