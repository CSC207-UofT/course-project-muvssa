package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Entity.Workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Routine implements Serializable {
    private String name;
    private String description;
    private List<Workout> workouts;

    // Empty constructor necessary for Firebase
    @SuppressWarnings("unused")
    public Routine() {
    }

    /**
     * A constructor that creates a Routine given a name and list of workouts
     *
     * @param name the name of the Routine
     */
    public Routine(String name, String description) {
        this.name = name;
        this.description = description;
        this.workouts = new ArrayList<>();
    }

    /**
     * Gets the name
     *
     * @return name of the Routine
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Routine to something new
     *
     * @param name the new name of Routine
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description
     *
     * @return description of the Routine
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description to a given one
     *
     * @param description new description for the Routine
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of workouts
     *
     * @return list of workouts for the Routine
     */
    public List<Workout> getWorkouts() {
        return workouts;
    }

    /**
     * Sets the Routine's workouts to new ones given
     *
     * @param workouts list of new workouts
     */
    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    /**
     * Add a workout to the Routine
     *
     * @param workout new workout to be added
     */
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }

    /**
     * Remove a workout if the given name matches any of the workout names from the Routine
     *
     * @param name name of the workout to be removed from Routine's workouts
     */
    public void removeWorkout(String name) {
        this.workouts.removeIf(workout -> workout.getName().equals(name));
    }

    /**
     * Remove every single workout from the Routine
     */
    public void removeAllWorkouts() {
        this.workouts.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Routine))
            return false;
        Routine routine = (Routine) o;
        // erroring as when you want to update a specfic routine it could have diffrent workouts
        //return name.equals(routine.name) && description.equals(routine.description) &&
        //        workouts.equals(routine.workouts);
        return name.equals(routine.name);
    }
}