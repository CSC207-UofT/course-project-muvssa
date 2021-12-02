package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise;
import com.example.fitappa.Exercise.ExerciseTemplate;
import com.example.fitappa.Exercise.RepExercise;

import junit.framework.TestCase;

public class TrackWorkoutsTest extends TestCase {

    WorkoutTemplate workoutTemplate;
    ExerciseTemplate exerciseTemplate;

    public void setup() {
        this.workoutTemplate = new WorkoutTemplate("My workout");
        this.exerciseTemplate = new ExerciseTemplate("My exercise",5, "REP");
        this.workoutTemplate.addExercise(exerciseTemplate);
    }

    public void testInitialState() {

        TrackWorkouts tracker = new TrackWorkouts();
        assertFalse(tracker.isTracking());
    }

}