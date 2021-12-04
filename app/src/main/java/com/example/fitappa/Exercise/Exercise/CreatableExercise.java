package com.example.fitappa.Exercise.Exercise;

public interface CreatableExercise {
    PerformExercise<?> create();
    String getName();
    String getCategory();
}