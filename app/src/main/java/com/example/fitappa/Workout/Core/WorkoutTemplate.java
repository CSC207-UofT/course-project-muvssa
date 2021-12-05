package com.example.fitappa.Workout.Core;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;

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
     * @param name represents the String name referring to the name of the workout
     */
    public WorkoutTemplate(String name) {
        this.name = name;
        this.exerciseTemplates = new ArrayList<>();
    }

    /**
     * Constructor for WorkoutTemplate
     */
    @SuppressWarnings("unused")
    public WorkoutTemplate() {
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
     * Change the workouts name
     *
     * @param name new name for workout
     */
    public void setName(String name) {
        this.name = name;
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
    public void addExercise(ExerciseTemplate exerciseTemplate) {
        this.exerciseTemplates.add(exerciseTemplate);
    }


    // TODO: Whoever created this method, please add the javadocs
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WorkoutTemplate))
            return false;
        WorkoutTemplate workoutTemplate = (WorkoutTemplate) o;
        // erroring as when you want to update a specific routine it could have different workouts
        // return name.equals(routine.name) && description.equals(routine.description) &&
        //        workouts.equals(routine.workouts);
        return name.equals(workoutTemplate.getName());
    }


}

