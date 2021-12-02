package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise;
import com.example.fitappa.Exercise.ExerciseTemplate;
import com.example.fitappa.Exercise.RepExercise;
import com.example.fitappa.Exercise.Set;
import com.example.fitappa.Exercise.Settable;

import junit.framework.TestCase;

public class TrackWorkoutsTest extends TestCase {

    WorkoutTemplate workoutTemplate;
    ExerciseTemplate exerciseTemplate;

    public void setUp() throws Exception {
        this.workoutTemplate = new WorkoutTemplate("My workout");
        this.exerciseTemplate = new ExerciseTemplate("My exercise",5, "REP");
        this.workoutTemplate.addExercise(exerciseTemplate);
    }

    public void testInitialState() {

        // Ensure the template is ready
        assertNotNull(this.workoutTemplate);

        TrackWorkouts tracker = new TrackWorkouts();
        assertFalse(tracker.isTracking());

        tracker.track(this.workoutTemplate);
        assertTrue(tracker.isTracking());

        // Test tracking the workout
        tracker.addSet(0, (Settable) new Set(10));
        tracker.addSet(0, (Settable) new Set(8));
        tracker.addSet(0, (Settable) new Set(6));
        tracker.addSet(0, (Settable) new Set(4));

        tracker.end();

        assertFalse(tracker.isTracking());

        assertEquals(1, tracker.getTotalWorkouts());

    }



}