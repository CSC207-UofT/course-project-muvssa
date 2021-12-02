package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.ExerciseTemplate;
import com.example.fitappa.Exercise.Set;

import java.time.LocalDateTime;
import java.util.List;

public class Workout {
    private String name;
    private List<ExerciseTemplate> exerciseTemplates;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Creates a new Workout
     * @param name represents the name of the workout
     * @param exerciseTemplates represents the list of exercises for this workout
     */
    public Workout(String name, List<ExerciseTemplate> exerciseTemplates) {
        this.name = name;
        this.exerciseTemplates = exerciseTemplates;
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
        this.exerciseTemplates.add(exerciseTemplate);
    }


    /**
     * Adds a set to an exercise in exercises.
     *
     * Precondition: 0 <= pos < exercises.size()
     *
     * @param pos represents
     * @param s
     * @return
     */
    public boolean addSet(int pos, Set s) {
        //exercises[pos].addSet(s);
        return false;
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
}
