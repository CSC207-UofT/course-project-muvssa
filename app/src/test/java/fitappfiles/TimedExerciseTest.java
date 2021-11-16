package fitappfiles;

import com.example.fitappa.Model.Entity.TimedExercise;
import junit.framework.TestCase;

public class TimedExerciseTest extends TestCase {
    TimedExercise x;
    TimedExercise y;

    public void setUp() throws Exception {
        x = new TimedExercise("stretching", 4, 2, "whole body", 2);
        y = new TimedExercise("jogging", 5, 3, "leg muscle", 4);
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetSet_time() {
        assertEquals(2, x.getSet_time());
        assertEquals(4, y.getSet_time());
    }

    public void testGetVolume() {
        assertEquals(8.0, x.getVolume());
        assertEquals(20.0, y.getVolume());
    }
}