package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise;
import com.example.fitappa.Exercise.ExerciseTemplate;
import com.example.fitappa.Exercise.Set;
import com.example.fitappa.Exercise.Settable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String name;
    private List<Exercise> exercises;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Creates a new Workout
     * @param name represents the name of the workout
     * @param exerciseTemplates represents the list of exercises for this workout
     */
    public Workout(String name, List<ExerciseTemplate> exerciseTemplates) {
        this.name = name;
        this.exercises = new ArrayList<Exercise>();
        for(ExerciseTemplate exerciseTemplate : exerciseTemplates) {
            this.exercises.add(exerciseTemplate.create());
        }
        // The creation of the workout indicates the workout has started
        this.startTime = LocalDateTime.now();
    }


    /**
     * Getter for this.name
     * @return the name of the workout
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for this.name
     * @param name the name of the workout
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds an exercise to the workout
     * @param exerciseTemplate represents the exercise to add
     */
    public void addExercise(ExerciseTemplate exerciseTemplate) {
        this.exercises.add(exerciseTemplate.create());
    }


    /**
     * Adds a set to an exercise in exercises.
     *
     * Precondition: 0 <= pos < exercises.size()
     *
     * @param i represents
     * @param s
     * @return
     */
    public void addSet(int i, Settable s) {
        this.exercises.get(i).addSet(s);
    }


    /**
     *
     * A workout is defined to be "finished" if there exists a endTime
     *
     * @return True if the workout is finished
     */
    public boolean isFinished() {
        return !(endTime == null);
    }

    public double volume() {
        double vol = 0;
        for(Exercise e : exercises) {
            vol += e.volume();
        }
        return vol;
    }

    public void finish() {
        this.endTime = LocalDateTime.now();
    }
}
