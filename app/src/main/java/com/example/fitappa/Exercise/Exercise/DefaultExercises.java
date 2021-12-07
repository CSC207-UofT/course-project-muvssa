package com.example.fitappa.Exercise.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * This class implements the factory design patter to create different exercises
 *
 * Methods in this class help create different exercises
 *
 * Documentation specifies what the methods do
 *
 * @author Abdullah
 *
 * @since 0.8
 */

public class DefaultExercises implements Serializable {
    private List<ExerciseTemplate> exerciseTemplates;

    /**
     * Constructor that initializes empty ArrayList of exercises
     */
    public DefaultExercises() {
        this.exerciseTemplates = new ArrayList<>();
    }

    /**
     * Retrieve the list of exercises
     *
     * @return List of exercises contained within this class
     */
    public List<ExerciseTemplate> getExercises() {
        return exerciseTemplates;
    }

    /**
     * Set the exercises in this class
     *
     * @param exerciseTemplates List of exercises to be set
     */
    public void setExercises(List<ExerciseTemplate> exerciseTemplates) {
        this.exerciseTemplates = exerciseTemplates;
    }

    /**
     * Add an exercise to the list of exercises
     *
     * @param exerciseTemplate Exercise to be added to the list
     */
    public void addExercise(ExerciseTemplate exerciseTemplate) {
        this.exerciseTemplates.add(exerciseTemplate);
    }

    /**
     * Remove an exercise from the list of exercises
     *
     * @param exerciseTemplate Exercise to be removed from the list
     */
    public void removeExercise(ExerciseTemplate exerciseTemplate) {
        this.exerciseTemplates.remove(exerciseTemplate);
    }
}
