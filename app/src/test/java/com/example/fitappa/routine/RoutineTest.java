package com.example.fitappa.routine;

import junit.framework.TestCase;

/**
 * Test Routines
 */
public class RoutineTest extends TestCase {
    Routine x;

    /**
     * Sets up the class
     * @throws Exception incase
     */
    public void setUp() throws Exception {
        x = new Routine("sundays");
        super.setUp();
    }

    /**
     * test get name
     */
    public void testTestGetName() {
        assertEquals("sundays", x.getName());
    }
}