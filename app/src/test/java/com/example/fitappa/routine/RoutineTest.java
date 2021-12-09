package com.example.fitappa.routine;

import junit.framework.TestCase;

/**
 * Tets the Routine class
 */
public class RoutineTest extends TestCase {
    Routine x;

    /**
     * Sets up the class
     * @throws Exception test
     */
    public void setUp() throws Exception {
        x = new Routine("sundays");
        super.setUp();
    }

    /**
     * Tests getName
     */
    public void testTestGetName() {
        assertEquals("sundays", x.getName());
    }

}