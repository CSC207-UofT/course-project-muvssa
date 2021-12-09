package com.example.fitappa.exercise.set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {
    RepSet x;
    WeightedSet y;

    @Before
    public void setUp() throws Exception {
        //set up a RepSet and WeightedSet object
        x = new RepSet(10.0);
        y = new WeightedSet(10.0, 20.0);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        //checks to see if ToString result matches desired string
        assertEquals("Reps: 10.0", x.toString());
        assertEquals("Weight: 20.0lbs | Reps: 10.0", y.toString());
        assertTrue(y.toString() instanceof String);
    }
}