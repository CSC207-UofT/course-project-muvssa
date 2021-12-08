package com.example.fitappa.routine;

import junit.framework.TestCase;

public class RoutineTest extends TestCase {
    Routine x;

    public void setUp() throws Exception {
        x = new Routine("sundays");
        super.setUp();
    }

    public void testTestGetName() {
        assertEquals("sundays", x.getName());
    }


    public void testGetWorkouts() {
//        x.addWorkout(workoutTemplate);
//        assertTrue(x.getWorkouts().contains(workoutTemplate));
    }

    public void testSetWorkouts() {
    }

    public void testTestEquals() {
    }
}