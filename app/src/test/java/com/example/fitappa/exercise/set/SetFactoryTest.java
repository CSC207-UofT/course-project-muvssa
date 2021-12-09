package com.example.fitappa.exercise.set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetFactoryTest {
    SetFactory x;
    RepSet y;
    WeightedSet z;
    @Before
    public void setUp() throws Exception {
        //set up a set factory object, a RepSet object and a WeightedSet object
        x = new SetFactory();
        y = new RepSet(10);
        z = new WeightedSet(15, 20);
    }

    @After
    public void tearDown() throws Exception {
    }

    //checks to see if the types of the buildSet method result and our corresponding set objects match
    //also checks number of reps to ensure matching
    @Test
    public void buildSet() {
        int reps = 10;
        assertNotSame(z, x.buildSet(reps));
        assertEquals(y.numReps, x.buildSet(reps).numReps, reps);
    }
    @Test
    public void testBuildSet() {
        int reps = 15;
        assertEquals(z.numReps, x.buildSet(reps, 20).numReps, reps);
        assertNotSame(y, x.buildSet(reps, 20));

    }
}