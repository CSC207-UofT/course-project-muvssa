package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Set.SetFactory;
import com.example.fitappa.Exercise.Set.Set;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Track Workout Use Case.
 *
 * Fundamentally, this class should enable you to track workouts and store
 * them in history.
 *
 * @author abdullah
 * @version 0.1
 */
public class TrackWorkouts implements Serializable {
    private final List<Workout> workouts;
    private final SetFactory setFactory;
    private Workout currWorkout;

    /**
     * Creates a workout tracker with an empty history
     */
    public TrackWorkouts() {
        this.workouts = new ArrayList<>();
        this.setFactory = new SetFactory();
    }

    /**
     * @return The total volume generated by all the workouts in the tracker.
     */
    public double volume() {
        double vol = 0;
        for(Workout workout : workouts) {
            vol += workout.volume();
        }
        return vol;
    }

    /**
     * @return The average duration of a workout in the tracker
     */
    public double getAvgDuration() {
        /*double sum = 0;

        for (WorkoutTemplate workoutTemplate : this.workoutTemplateHistory) {
            sum += workoutTemplate.calc().toMinutes();
        }

        return sum / this.workoutTemplateHistory.size();*/
        return 0;
    }


    /**
     * This method starts a workout. A workout can be started iff there is no unfinished workout.
     *
     * @param workoutTemplate - The workout that is to be started
     * @return True iff the workout was successfully started
     */
    public boolean track(WorkoutTemplate workoutTemplate) {
        if(this.isTracking()) return false;

        this.currWorkout = workoutTemplate.createWorkout();
        return true;
    }

    /**
     * This method returns if a workout is being tracked
     * @return true iff this.currWorkout != null
     */
    public boolean isTracking() {
        return this.currWorkout != null;
    }

    /**
     * Precondition: 1) 0 <= i < this.currWorkout.length(),
     *               2) the exercise at position <i> is of type RepExercise
     * @param i represents the position of the exercise
     * @param numReps represents the number of reps to add in the set
     */
    public void addSet(int i, int numReps) {
        this.currWorkout.addSet(i, (Set) setFactory.buildSet(numReps));
    }

    /**
     * Precondition: 1) 0 <= i < this.currWorkout.length(),
     *               2) the exercise at position <i> is of type WeightedExercise
     * @param i represents the position of the exercise
     * @param numReps represents the number of reps to add in the set
     * @param weight represents the weight to add in the set
     */
    public void addSet(int i, int numReps, double weight) {
        this.currWorkout.addSet(i, (Set) setFactory.buildSet(numReps, weight));
    }

    /**
     * Precondition: 1) 0 <= i < this.currWorkout.length(),
     *               2) the exercise at position <i> is of type TimedExercise
     * @param i represents the position of the exercise
     * @param time represents the time in seconds to add to the set
     */
    public void addSet(int i, double time) {
        this.currWorkout.addSet(i, (Set) setFactory.buildSet(time));
    }


    /**
     * this method ends the current workout
     */
    public void end() {
        this.currWorkout.finish();
        workouts.add(this.currWorkout);
        this.currWorkout = null;
    }

    /**
     * This method return the total workouts that were tracked
     * @return the total workouts that were tracked
     */
    public int getTotalWorkouts() {
        return this.workouts.size();
    }


}
