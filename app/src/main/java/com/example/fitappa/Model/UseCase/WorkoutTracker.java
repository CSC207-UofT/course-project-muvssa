package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Entity.Workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkoutTracker implements Serializable {
    private final List<Workout> workoutHistory;
    private Workout currWorkout;

    /**
     * Creates a workout tracker with an empty history
     */
    public WorkoutTracker() {
        this.workoutHistory = new ArrayList<>();
    }

    /**
     * @return The total volume generated by all the workouts in the tracker.
     */
    public double getTotalVolume() {
        double volume = 0;
        for (Workout workout : this.workoutHistory) {
            volume += workout.getTotalVolume();
        }
        return volume;
    }

    /**
     * @return The average duration of a workout in the tracker
     */
    public double getAvgDuration() {
        double sum = 0;

        for (Workout workout : this.workoutHistory) {
            sum += workout.calculateDuration().toMinutes();
        }

        return sum / this.workoutHistory.size();
    }


    /**
     * This method starts a workout. A workout can be started iff there is no unfinished workout.
     *
     * @param workoutTemplate - The workout that is to be started
     * @return True iff the workout was successfully started
     */
    public boolean startWorkout(Workout workoutTemplate) {
        if (this.currWorkout == null) {
            this.currWorkout = new Workout(workoutTemplate);
            return true;
        }

        return false;

    }
}
