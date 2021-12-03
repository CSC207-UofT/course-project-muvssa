package com.example.fitappa.Exercise.Set;

/**
 * This class incorporates the factory method
 * and returns appropriate sets given the information
 *
 * The methods in this class implement the factory design pattern creating the different sets
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @since 0.1
 */
public class SetFactory {

    /**
     * a set that takes in rep information is a rep set.
     * @param numReps represents the number of reps
     * @return a RepSet
     */
    public RepSet buildSet(int numReps) {
        return new RepSet(numReps);
    }

    /**
     * a set that takes in rep & weight information is a weighted set.
     * @param numReps represents the number of reps
     * @return a WeightedSet
     */
    public WeightedSet buildSet(int numReps, double weight) {
        return new WeightedSet(numReps, weight);
    }

    /**
     * a set that takes in time information is a time set.
     * @param time represents the time taken to finish this set
     * @return a TimedSet
     */
    public TimedSet buildSet(double time) {
        return new TimedSet(time);
    }

}
