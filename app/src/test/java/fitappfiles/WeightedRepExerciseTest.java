package fitappfiles;

import com.example.fitappa.Model.Entity.WeightedRepExercise;
import junit.framework.TestCase;

public class WeightedRepExerciseTest extends TestCase {
    WeightedRepExercise x;
    WeightedRepExercise y;

    public void setUp() throws Exception {
        x = new WeightedRepExercise("weights", 3, 4, "arms", 3, 76.8);
        y = new WeightedRepExercise("routine", 4, 2, "all", 4, 23.56);

        super.setUp();
    }

    public void testGetWeight() {
        assertEquals(76.8, x.getWeight());
        assertEquals(23.56, y.getWeight());
    }
}