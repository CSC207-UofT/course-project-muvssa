package fitappfiles;

import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;
import junit.framework.TestCase;

import java.util.ArrayList;

public class RoutineTest extends TestCase {
    Routine x;
    Workout workout;

    public void setUp() throws Exception {
        workout = new Workout("chest", "easy");
        x = new Routine("sundays", "hard");
        super.setUp();
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
        x.addWorkout(workout);
        assertTrue(x.getWorkouts().contains(workout));
    }

    public void testSetWorkouts() {
        Workout workout1 = new Workout("legs", "hard");
        ArrayList<Workout> workouts = new ArrayList<>();
        workouts.add(workout);
        workouts.add(workout1);
        x.setWorkouts(workouts);
        assertEquals(2, x.getWorkouts().size());
    }

    public void testAddWorkout() {
    }

    public void testRemoveWorkout() {
        x.addWorkout(workout);
        assertEquals(1, x.getWorkouts().size());
        x.removeWorkout(workout.getName());
        assertEquals(0, x.getWorkouts().size());
    }

    public void testRemoveAllWorkouts() {
        x.addWorkout(workout);
        assertEquals(1, x.getWorkouts().size());
        x.removeAllWorkouts();
        assertEquals(0, x.getWorkouts().size());
    }

    public void testTestEquals() {
    }
}