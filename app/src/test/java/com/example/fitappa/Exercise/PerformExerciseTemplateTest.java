package com.example.fitappa.Exercise;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;

import junit.framework.TestCase;

public class PerformExerciseTemplateTest extends TestCase {
    ExerciseTemplate x;
    ExerciseTemplate y;

    public void setUp() throws Exception {
        x = new ExerciseTemplate("skipping", 10, "REP");
        y = new ExerciseTemplate("running", 10, "REP");
        super.setUp();
    }

    public void testTestGetName() {
        assertEquals("skipping", x.getName());
        assertEquals("running", y.getName());
    }

    public void testGetNumSets() {
        assertEquals(10, x.getNumSets());
        assertEquals(10, y.getNumSets());
    }

}