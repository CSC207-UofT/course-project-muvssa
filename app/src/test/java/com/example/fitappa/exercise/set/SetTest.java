package com.example.fitappa.exercise.set;

import org.junit.*;

import static org.junit.Assert.*;

public class SetTest {
    RepSet x;
    WeightedSet y;

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
        System.out.println("Executing a new test");
        //set up a RepSet and WeightedSet object
        x = new RepSet(10.0);
        y = new WeightedSet(10.0, 20.0);
    }

    @After
    public void tearDown() throws Exception {System.out.println("Execution done");
    }

    @Test
    public void testToString() {
        //checks to see if ToString result matches desired string
        assertEquals("Reps: 10.0", x.toString());
        assertEquals("Weight: 20.0lbs | Reps: 10.0", y.toString());
        assertTrue(y.toString() instanceof String);
    }
}