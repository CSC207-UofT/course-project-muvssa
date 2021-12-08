package com.example.fitappa.workout.workout_template;

import com.example.fitappa.exercise.exercise_template.Category;
import com.example.fitappa.exercise.exercise_template.ExerciseTemplate;
import com.example.fitappa.exercise.set.SetFactory;

import junit.framework.TestCase;

public class AnalyzeWorkoutsTest extends TestCase {

    WorkoutTemplate workoutTemplate;
    ExerciseTemplate exerciseTemplate;
    SetFactory setFactory;

    public void setUp() {
        this.workoutTemplate = new WorkoutTemplate("My workout");
        this.exerciseTemplate = new ExerciseTemplate("My exercise", 5, Category.REP);
        this.workoutTemplate.addExercise(exerciseTemplate);
        this.setFactory = new SetFactory();
    }

    public void testInitialState() {

        // Ensure the template is ready
        assertNotNull(this.workoutTemplate);

        /*TrackWorkouts tracker = new TrackWorkouts();
        assertFalse(tracker.isTracking());

        tracker.track(this.workoutTemplate);
        assertTrue(tracker.isTracking());

        // Test tracking the workout
        tracker.addSet(0, 10);
        tracker.addSet(0, 10);
        tracker.addSet(0, 8);
        tracker.addSet(0, 6);

        tracker.end();

        assertFalse(tracker.isTracking());

        assertEquals(1, tracker.getTotalWorkouts());*/

    }

    public void testMultipleExerciseWorkout() {

        // A workout with all 3 types of exercises
        /*this.workoutTemplate.addExercise(
                new ExerciseTemplate("Bench Press", 3, "WEIGHTED"));
        this.workoutTemplate.addExercise(
                new ExerciseTemplate("Plank", 2, "TIMED"));

        /*
         * exercise 1: My exercise
         * exercise 2: Bench Press
         * exercise 3: Plank
         */
       /* TrackWorkouts tracker = new TrackWorkouts();
        tracker.track(this.workoutTemplate);

        assertTrue(tracker.isTracking());

        tracker.addSet(0, 10);
        tracker.addSet(0, 10);
        tracker.addSet(0, 12);

        tracker.addSet(1, 10, 100);
        tracker.addSet(1, 10, 200);

        tracker.addSet(2, 60.0);

        tracker.end();
        assertFalse(tracker.isTracking());


        assertEquals(3000.0, tracker.volume());*/

    }



}