package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.WeightedRepExercise;

import java.util.ArrayList;

//////// TEMPORARY CLASS

public class ExerciseRepository {
    private final ArrayList<Exercise> e;


    public ExerciseRepository() {
        // Temporary database
        e = new ArrayList<>();
        e.add(new WeightedRepExercise("Bench-press"));
        e.add(new WeightedRepExercise("Dead-lift"));
        e.add(new WeightedRepExercise("Squat"));
        e.add(new WeightedRepExercise("Barbell Row"));
    }

    public ArrayList<Exercise> getExercises() {
        return this.e;
    }
}
