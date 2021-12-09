package com.example.fitappa.workout.workout_template;

import com.example.fitappa.exercise.exercise_template.ExerciseTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a workout template that is created by the user
 *
 * @author abdullah
 * @version 0.1
 * @layer 1
 */
public class WorkoutTemplate implements Serializable {
    private String name;
    private final List<ExerciseTemplate> exerciseTemplates;

    /**
     * Constructor for a WorkoutTemplate
     *
     * @param name represents the String name referring to the name of the workout
     */
    public WorkoutTemplate(String name) {
        this.name = name;
        this.exerciseTemplates = new ArrayList<>();
    }

    public WorkoutTemplate(String name, List<ExerciseTemplate> exerciseTemplates) {
        this.name = name;
        this.exerciseTemplates = exerciseTemplates;
    }

    /**
     * Constructor for WorkoutTemplate
     */
    @SuppressWarnings("unused")
    WorkoutTemplate() {
        exerciseTemplates = new ArrayList<>();
    }

    /**
     * A getter method
     * returns the name of the workout
     *
     * @return the string name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the exercises for this workout
     *
     * @return list of exercises for this workout
     */
    public List<ExerciseTemplate> getExercises() {
        return exerciseTemplates;
    }

    /**
     * A method used to add exercises
     *
     * @param exerciseTemplate new exercise to be added to workout
     */
    void addExercise(ExerciseTemplate exerciseTemplate) {
        this.exerciseTemplates.add(exerciseTemplate);
    }


}

