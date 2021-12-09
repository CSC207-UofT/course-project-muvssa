package com.example.fitappa.exercise.set;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Tests the Set interface
 */
public class SetTest {
    RepSet x;
    WeightedSet y;

    /**
     * Set up
     */
    @BeforeClass
    public static void setUpBeforeClass(){
        System.out.println("Executing a JUNIT test file");
    }

    /**
     * Tear down
     */
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Execution of JUNIT test file done");
    }

    /**
     * Set up
     */
    @Before
    public void setUp() {
        System.out.println("Executing a new test");
        //set up a RepSet and WeightedSet object
        x = new RepSet(10.0);
        y = new WeightedSet(10.0, 20.0);
    }

    /**
     * Tear down
     */
    @After
    public void tearDown()  {System.out.println("Execution done");
    }

    /**
     * Test toString
     */
    @Test
    public void testToString() {
        //checks to see if ToString result matches desired string
        assertEquals("Reps: 10.0", x.toString());
        assertEquals("Weight: 20.0lbs | Reps: 10.0", y.toString());
    }
}