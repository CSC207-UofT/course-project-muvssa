package com.example.fitappa.exercise.set;

import androidx.annotation.NonNull;

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
     * String representation of the set
     * @return String
     */
    @NonNull
    String toString();

}
