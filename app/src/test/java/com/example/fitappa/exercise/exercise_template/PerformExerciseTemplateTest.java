package com.example.fitappa.exercise.exercise_template;

import com.example.fitappa.exercise.set.RepSet;
import com.example.fitappa.exercise.set.WeightedSet;
import com.example.fitappa.workout.track_workout.PerformExercise;

import junit.framework.TestCase;

/**
 * tests PerformExercise class and ExerciseTemplate class
 * Two ExerciseTemplate objects are created for this test
 */
@SuppressWarnings("unused")
public class PerformExerciseTemplateTest extends TestCase {
    ExerciseTemplate x;
    ExerciseTemplate y;
    PerformExercise<?> n;


    /**
     * Setup
     *
     * @throws Exception in case
     */
    public void setUp() throws Exception {
        x = new ExerciseTemplate("skipping", 10, Category.REP);
        y = new ExerciseTemplate("curls", 20, Category.WEIGHTED);
        n = x.create();
        super.setUp();
    }

    /**
     * Test get name
     */
    public void testTestGetName() {
        //sees if the name matches string once got
        assertEquals("skipping", x.getName());
        assertEquals("curls", y.create().getName());
        assertNotSame("skipping", y.create().getName());
    }

    /**
     * Test get Num Sets
     */
    public void testGetNumSets() {
        //sees if the number of sets matches int once got
        assertEquals(10, x.getNumSets());
        assertEquals(20, y.getNumSets());
        assertNotSame(10, y.getNumSets());
    }

    /**
     * Test get category
     */
    public void testGetCategory() {
        //sees if the category matches once got
        assertEquals(Category.REP, x.create().getCategory());
        assertEquals(Category.WEIGHTED, y.getCategory());
        assertNotSame(Category.REP, y.getCategory());
    }

    /**
     * Test Create
     */
    public void testCreate() {
        //sees if the instances match once the PerformExercise object is created
        assertEquals("skipping", x.create().getName());
        assertEquals(Category.WEIGHTED, y.create().getCategory());
    }


    /**
     * Test add and get set
     */
    public void testAddGetSet() {
        //sees if adding a set in to the list of sets works
        //also checks if getSet method works
        RepSet s1 = new RepSet(10.0);
        WeightedSet s2 = new WeightedSet(10.0, 20.1);
        PerformExercise<?> x1 = x.create();
        x1.addSet(s1);
        assertEquals(1, x1.getSets().size());
        assertEquals(s1, x1.getSets().get(x1.getSets().size() - 1));
        x1.addSet(s2);
        assertEquals(2, x1.getSets().size());
        assertEquals(s2, x1.getSets().get(x1.getSets().size() - 1));
    }


}