package com.example.fitappa.Exercise.Set;

/**
 * This interface represents a set.
 * Completing several reps of a specific exercise in a row is called a set.
 * Thus, a set generally represents a measure of "reps" for an exercise.
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 */
public interface Set {

    /**
     * The volume of a set is defined to be the work completed during the set.
     * The formula for volume for a weighted set is weight * reps
     * The formula for volume for calisthenics set is body-weight * reps
     * Otherwise, the volume is 0.
     * @return volume
     */
    double volume();

    /**
     * a set is complete when the repetition is set.
     * @return true if the set is complete
     */
    boolean isComplete();

    String toString();

}
