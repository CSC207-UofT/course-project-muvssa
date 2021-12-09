package com.example.fitappa.exercise;

import com.example.fitappa.exercise.exercise_template.Category;
import com.example.fitappa.exercise.exercise_template.ExerciseTemplate;

import junit.framework.TestCase;

/**
 * Tests the PerformExercise class
 */
public class PerformExerciseTemplateTest extends TestCase {
    ExerciseTemplate x;
    ExerciseTemplate y;

    /**
     * Set up app
     * @throws Exception is thrown
     */
    public void setUp() throws Exception {
        x = new ExerciseTemplate("skipping", 10, Category.REP);
        y = new ExerciseTemplate("running", 10, Category.REP);
        super.setUp();
    }

    /**
     * Test getName
     */
    public void testTestGetName() {
        assertEquals("skipping", x.getName());
        assertEquals("running", y.getName());
    }

    /**
     * test get num sets
     */
    public void testGetNumSets() {
        assertEquals(10, x.getNumSets());
        assertEquals(10, y.getNumSets());
    }

}