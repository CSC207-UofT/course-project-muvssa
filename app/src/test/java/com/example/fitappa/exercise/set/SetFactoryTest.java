package com.example.fitappa.exercise.set;


import org.junit.*;

import static org.junit.Assert.*;
/**
 * This class is a testing class for SetFactory, an element in implementation of the Factory design patterns.
 * <p>
 * The methods in this class are testing methods to see if the corresponding methods in the actual class work.
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Munim
 */
public class SetFactoryTest {
    SetFactory x;
    RepSet y;
    WeightedSet z;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Executing a JUNIT test file");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Execution of JUNIT test file done");
    }

    @Before
    public void setUp() throws Exception {
        /**
         * This setup method allows us to set up a few objects for testing purposes.
         * *
         * @objects x is a SetFactory object that we will test
         * y is a RepSet object to support in testing of x
         * z is a WeightedSet object to support in testing of x
         */
        System.out.println("Executing a new test");
        x = new SetFactory();
        y = new RepSet(10);
        z = new WeightedSet(15, 20);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Execution done");
    }

    /**
     * This method allows us to test the buildSet function
     * *
     * checks to see if the types of the buildSet method result and our corresponding set objects match
     * also checks the number of reps to ensure the match
     *
     * method was simply called, no special situations
     */

    @Test
    public void testBuildSet() {
        int reps = 15;
        assertEquals(y.numReps, x.buildSet(reps).numReps, reps);
        assertEquals(z.numReps, x.buildSet(reps, 20).numReps, reps);
        assertNotSame(y, x.buildSet(reps, 20));
        int reps1 = 14;
        int reps2 = 20;
        assertTrue(x.buildSet(reps1) instanceof RepSet);
        assertTrue(x.buildSet(reps2, 20.0) instanceof WeightedSet);
    }
}