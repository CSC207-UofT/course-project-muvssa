package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.WeightedRepExercise;

import java.util.ArrayList;

public class ExerciseRepository {
    private ArrayList<Exercise> e;


    public ExerciseRepository() {
        // Temporary database
        e = new ArrayList<Exercise>();
        e.add(new WeightedRepExercise("Benchpress"));
        e.add(new WeightedRepExercise("Deadlift"));
        e.add(new WeightedRepExercise("Squat"));
        e.add(new WeightedRepExercise("Barbell Row"));
    }

    public ArrayList<Exercise> getExercises() {
        return this.e;
    }
}
