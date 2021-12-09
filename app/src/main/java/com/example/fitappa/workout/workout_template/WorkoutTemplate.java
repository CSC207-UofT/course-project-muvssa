package com.example.fitappa.workout.workout_template;

import androidx.annotation.NonNull;

import com.example.fitappa.exercise.exercise_template.ExerciseTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a workout template that is created by the user
 *
 * @author abdullah
 * @version 0.1
 * @layer 1
 */
public class WorkoutTemplate implements Serializable, Iterable<ExerciseTemplate> {
    private final String name;
    private final List<ExerciseTemplate> exerciseTemplates;

    /**
     * Constructor for a WorkoutTemplate
     *
     * @param name represents the String name referring to the name of the workout
     */
    WorkoutTemplate(String name) {
        this.name = name;
        this.exerciseTemplates = new ArrayList<>();
    }

    public WorkoutTemplate(String name, List<ExerciseTemplate> exerciseTemplates) {
        this.name = name;
        this.exerciseTemplates = exerciseTemplates;
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
     * A method used to add exercises
     *
     * @param exerciseTemplate new exercise to be added to workout
     */
    void addExercise(ExerciseTemplate exerciseTemplate) {
        this.exerciseTemplates.add(exerciseTemplate);
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NonNull
    @Override
    public Iterator<ExerciseTemplate> iterator() {
        return exerciseTemplates.iterator();
    }
}

