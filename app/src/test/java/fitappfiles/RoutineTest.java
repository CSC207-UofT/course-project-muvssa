package fitappfiles;

import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Model.Entity.Workout;
import junit.framework.TestCase;

public class RoutineTest extends TestCase {
    Routine x;
    Workout workout;

    public void setUp() throws Exception {
        workout = new Workout("chest", "easy");
        x = new Routine("sundays", "hard");
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        assertEquals("sundays", x.getName());
    }

    public void testTestSetName() {
        x.setName("o");
        assertEquals("o", x.getName());
    }

    public void testGetDescription() {
        assertEquals("hard", x.getDescription());
    }

    public void testSetDescription() {
        x.setDescription("good");
        assertEquals("good", x.getDescription());
    }

    public void testGetWorkouts() {
        assertEquals(workout, x.getWorkouts());
    }

    public void testSetWorkouts() {
    }

    public void testAddWorkout() {
    }

    public void testRemoveWorkout() {
    }

    public void testRemoveAllWorkouts() {
    }

    public void testTestEquals() {
    }
}