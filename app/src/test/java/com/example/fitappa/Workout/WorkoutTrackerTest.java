package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise;
import com.example.fitappa.Exercise.RepExercise;
import junit.framework.TestCase;

import java.util.ArrayList;

// TODO: Phase 2
public class WorkoutTrackerTest extends TestCase {
    Workout workout;
    WorkoutTracker tracker;
    Exercise ex;
    ArrayList<Workout> workoutHistory;

    public void setUp() throws Exception {
        workout = new Workout("chest", "easy");
        ex = new RepExercise("squats", 5, 1, "quads", 25);
        tracker = new WorkoutTracker();
        workoutHistory = new ArrayList<>();
        workoutHistory.add(workout);

    }

    public void testGetTotalVolume() {
        assertEquals(0.0, tracker.getTotalVolume());
    }

    public void testGetAvgDuration() {
    }

    public void testStartWorkout() {
    }
}