package com.example.fitappa.routine;

import androidx.annotation.NonNull;

import com.example.fitappa.workout.workout_template.WorkoutTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class is a use case class meant to create a Routine object to hold a list of workouts
 * <p>
 * The method in the class allow the creation and interaction with a Routine holding multiple workouts
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.7
 */

class Routine implements Serializable, Iterable<WorkoutTemplate> {
    private String name;
    private List<WorkoutTemplate> workoutTemplates;

    // Empty constructor necessary for Firebase
    @SuppressWarnings("unused")
    public Routine() {
        workoutTemplates = new ArrayList<>();
    }

    /**
     * A constructor that creates a Routine given a name and list of workouts
     *
     * @param name the name of the Routine
     */
    Routine(String name) {
        this.name = name;
        this.workoutTemplates = new ArrayList<>();
    }

    /**
     * Gets the name
     *
     * @return name of the Routine
     */
    String getName() {
        return name;
    }

    /**
     * Get the list of workout templates from this routine
     *
     * @return List of WorkoutTemplate corresponding to this routine
     */
    List<WorkoutTemplate> getWorkouts() {
        return workoutTemplates;
    }

    /**
     * Sets the Routine's workouts to new ones given
     *
     * @param workoutTemplates list of new workouts
     */
    void setWorkouts(List<WorkoutTemplate> workoutTemplates) {
        this.workoutTemplates = workoutTemplates;
    }

    /**
     * Get the size of the workouts in this routine
     *
     * @return integer size of the workouts in this routine
     */
    int getSize() {
        return workoutTemplates.size();
    }

    /**
     * Returns an iterator over elements of type WorkoutTemplate
     *
     * @return an Iterator.
     */
    @NonNull
    @Override
    public Iterator<WorkoutTemplate> iterator() {
        return workoutTemplates.iterator();
    }
}