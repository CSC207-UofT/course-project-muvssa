package com.example.fitappa.exercise.exercise_template;

import com.example.fitappa.workout.track_workout.PerformExercise;

import junit.framework.TestCase;

/**
 * Test ExerciseTemplate class
 *
 * @author abdullah
 * @version 0.1
 */
public class ExerciseTemplateTest extends TestCase {
    private ExerciseTemplate repBased;
    private ExerciseTemplate weightBased;


    /**
     * Set up app
     */
    public void setUp() throws Exception {
        this.repBased = new ExerciseTemplate("Exercise 1", 0, Category.REP);

        this.weightBased = new ExerciseTemplate("Exercise 2", 0, Category.WEIGHTED);

        super.setUp();
    }

    /**
     * Test getCategory
     */
    public void testGetCategory() {
        assertSame(repBased.getCategory(), Category.REP);
        assertSame(weightBased.getCategory(), Category.WEIGHTED);
    }

    /**
     * Test Create (Rep Based)
     */
    public void testCreateRep() {
        PerformExercise<?> rep = this.repBased.create();
        assertSame(rep.getCategory(), repBased.getCategory());
    }

    /**
     * Test Create (Weight Based)
     */
    public void testCreateWeight() {
        PerformExercise<?> weight = this.weightBased.create();
        assertSame(weight.getCategory(), weightBased.getCategory());
    }


}