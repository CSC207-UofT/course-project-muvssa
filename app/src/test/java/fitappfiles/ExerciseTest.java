package fitappfiles;

import junit.framework.TestCase;

public class ExerciseTest extends TestCase {
    Exercise x;
    Exercise y;

    public void setUp() throws Exception {
        x = new Exercise("skipping", 3, 3, "o") {
            @Override
            public double getVolume() {
                return 0;
            }
        };
        y = new Exercise("running", 4, 2, "back") {
            @Override
            public double getVolume() {
                return 0;
            }
        };
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        assertEquals("skipping", x.getName());
        assertEquals("running", y.getName());
    }

    public void testGetNumSets() {
        assertEquals(3, x.getNumSets());
        assertEquals(4, y.getNumSets());
    }

    public void testGetNumRest() {
        assertEquals(3, x.getNumRest());
        assertEquals(2, y.getNumRest());
    }

    public void testGetMuscleGroup() {
        assertEquals("o", x.getMuscleGroup());
        assertEquals("back", y.getMuscleGroup());
    }

    public void testGetVolume() {
    }
}