package fitappfiles;

import com.example.fitappa.Model.Entity.RepExercise;
import junit.framework.TestCase;

public class RepExerciseTest extends TestCase {
    RepExercise x;
    RepExercise stretching;

    public void setUp() throws Exception {
        x = new RepExercise("qw", 2, 3, "back", 3);
        stretching = new RepExercise("stretching", 4, 2, "whole body", 3);
        super.setUp();
    }

    public void testGetNumReps() {
        assertEquals("3", x.getNumReps());
        assertEquals("3", stretching.getNumReps());
    }

    public void testGetVolume() {
        assertEquals(6.0, x.getVolume());
        assertEquals(12.0, stretching.getVolume());

    }
}