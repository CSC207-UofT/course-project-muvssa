package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Entity.Workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Routine implements Serializable {
    private String name;
    private String description;
    private ArrayList<Workout> workouts;

    /**
     * A constructor that creates a Routine given a name and list of workouts
     *
     * @param name        the name of the Routine
     * @param description the description of the Routine
     */
    public Routine(String name, String description, ArrayList<Workout> workouts) {
        this.name = name;
        this.description = description;
        this.workouts = workouts;
        this.workouts.add(new Workout("Pull", "Pull!!!"));
        this.workouts.add(new Workout("Push", "Pull!!!"));
    }

    /**
     * A constructor that creates a Routine given a name and list of workouts
     *
     * @param name     the name of the Routine
     */
    public Routine(String name, String description) {
        this.name = name;
        this.description = description;
        this.workouts = new ArrayList<Workout>();
        // Hard code
        //this.workouts.add(new Workout("Pull", "Pull!!!"));
        this.workouts.add(new Workout("Pull", "Pull!!!"));
        this.workouts.add(new Workout("Push", "Pull!!!"));
    }

    public Routine(String name) {
        this.name = name;
        this.description = "";
        this.workouts = new ArrayList<Workout>();
        this.workouts.add(new Workout("Pull", "Pull!!!"));
        this.workouts.add(new Workout("Push", "Pull!!!"));

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
    public ArrayList<Workout> getWorkouts() {
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


    public void addWorkout(String workoutName) {
        this.workouts.add(new Workout(workoutName, ""));
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
        return name.equals(routine.name) && description.equals(routine.description) &&
                workouts.equals(routine.workouts);
    }
}