package com.example.fitappa.Exercise.Set;

public interface Settable {

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

}
