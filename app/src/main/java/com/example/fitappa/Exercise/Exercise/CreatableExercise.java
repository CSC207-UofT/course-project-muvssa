package com.example.fitappa.Exercise.Exercise;

/**
 * This interface ensures that the implementor is creatable.
 *
 * Methods in this class use a factory method
 *
 * Documentation specifies what the methods do
 *
 * @author Abdullah
 *
 * @since 0.6
 */
public interface CreatableExercise {
    /**
     * factory method for PerformExercise
     * @return The correct PerformExercise object
     */
    PerformExercise<?> create();
}