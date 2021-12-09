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
@SuppressWarnings("ConstantConditions")
public class SetFactoryTest {
    SetFactory x;
    RepSet y;
    WeightedSet z;

    /**
     * Set up
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Executing a JUNIT test file");
    }

    /**
     * Setup
     */
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Execution of JUNIT test file done");
    }

    /**
     * This setup method allows us to set up a few objects for testing purposes.
     * *
     * y is a RepSet object to support in testing of x
     * z is a WeightedSet object to support in testing of x
     */
    @Before
    public void setUp() {
        System.out.println("Executing a new test");
        x = new SetFactory();
        y = new RepSet(10);
        z = new WeightedSet(15, 20);
    }


    /**
     * Tear down
     */
    @After
    public void tearDown() {
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