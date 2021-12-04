package com.example.fitappa.Exercise.Exercise;

/**
 * This interface ensures that the implementor is creatable.
 */
public interface CreatableExercise {
    /**
     * factory method for PerformExercise
     * @return The correct PerformExercise object
     */
    PerformExercise<?> create();
}