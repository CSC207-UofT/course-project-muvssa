package com.example.fitappa.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DefaultExercises implements Serializable {
    private List<Exercise> exercises;

    /**
     * Constructor that initializes empty ArrayList of exercises
     */
    public DefaultExercises() {
        this.exercises = new ArrayList<>();
    }

    /**
     * Retrieve the list of exercises
     *
     * @return List of exercises contained within this class
     */
    public List<Exercise> getExercises() {
        return exercises;
    }

    /**
     * Set the exercises in this class
     *
     * @param exercises List of exercises to be set
     */
    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    /**
     * Add an exercise to the list of exercises
     *
     * @param exercise Exercise to be added to the list
     */
    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    /**
     * Remove an exercise from the list of exercises
     *
     * @param exercise Exercise to be removed from the list
     */
    public void removeExercise(Exercise exercise) {
        this.exercises.remove(exercise);
    }
}
