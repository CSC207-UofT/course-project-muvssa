package com.example.fitappa.workout.track_workout;
import com.example.fitappa.exercise.exercise_template.Category;
import com.example.fitappa.exercise.exercise_template.ExerciseTemplate;
import com.example.fitappa.workout.workout_template.WorkoutTemplate;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Test the PerformWorkout class while simultaneously testing
 * ExerciseTemplate
 *
 * @author abdullah
 * @version 0.1
 */
public class PerformWorkoutTest extends TestCase {
    ExerciseTemplate repBased;
    ExerciseTemplate weightBased;
    WorkoutTemplate template;


    /**
     * Set up test
     */
    public void setUp() throws Exception {
        this.repBased =
                new ExerciseTemplate("Exercise 1", 0, Category.REP);

        this.weightBased =
                new ExerciseTemplate("Exercise 2", 0, Category.WEIGHTED);

        List<ExerciseTemplate> lst = new ArrayList<>();
        lst.add(repBased);
        lst.add(weightBased);

        this.template = new WorkoutTemplate("My workout", lst);

        super.setUp();
    }


    /**
     * Tests perform workout
     */
    public void testPerformWorkout() {
        PerformWorkout workout = new PerformWorkout(template);

        String e1 = workout.getExercises().get(0).getIdentifier();
        String e2 = workout.getExercises().get(1).getIdentifier();

        workout.addSet(e1, 10);

        workout.addSet(e2, 10, 100);

        workout.finish();

        assertEquals("Exercise 1 with the following sets: \n" +
                "Reps: 10.0\n",  workout.getExercises().get(0).toString());

        assertEquals("Exercise 2 with the following sets: \n" +
                "Weight: 100.0lbs | Reps: 10.0\n",  workout.getExercises().get(1).toString());

    }



}