package fitappfiles;

import android.graphics.drawable.shapes.RoundRectShape;
import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Model.Entity.Workout;
import junit.framework.TestCase;

import java.util.ArrayList;

public class RoutineTest extends TestCase {
    Routine x;
    Routine y;
    Routine z;
    Workout workout;
    ArrayList<Workout> list;
    ArrayList<Workout> newlist;
    Workout workout1;

    public void setUp() throws Exception {
        workout = new Workout("chest", "easy");
        workout1 = new Workout("curls", "medium");
        list = new ArrayList<Workout>();
        list.add(workout);
        x = new Routine("sundays", "hard", list);
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        assertEquals("sundays", x.getName());
    }
    //matches the name of the object retrieved by the getter

    public void testTestSetName() {
        x.setName("o");
        assertEquals("o", x.getName()); //matches the name that its been set to
    }

    public void testGetDescription() {
        assertEquals("hard", x.getDescription());
    } //matches the description retrieved by getter

    public void testSetDescription() {
        x.setDescription("good");
        assertEquals("good", x.getDescription()); //matches the description that has been set
    }

    public void testGetWorkouts() {
        list.add(workout1);
        assertEquals(workout1.description, x.getWorkouts().get(1).getDescription()); //shows that getter works
        assertNotSame(workout.description, x.getWorkouts().get(1).getDescription());
        assertEquals(2, list.size());
    }

    public void testSetWorkouts() {
        newlist = new ArrayList<Workout>();
        newlist.add(workout1);
        x.setWorkouts(newlist);
        assertEquals(workout1.description, x.getWorkouts().get(0).getDescription()); //index 0 and matching descriptions
        // show setter works
        assertEquals(1, newlist.size());
    }

    public void testAddWorkout() {
        assertEquals(1, x.getWorkouts().size());
        x.addWorkout(workout1);
        assertEquals(2,x.getWorkouts().size()); //increase in size signifies workout has been added

    }

    public void testRemoveWorkout() {
        x.addWorkout(workout1);
        x.removeWorkout(workout.name);
        assertEquals("curls", x.getWorkouts().get(0).getName()); //index 0 signifies removed workout
    }

    public void testRemoveAllWorkouts() {
        x.addWorkout(workout1);
        assertEquals(2, x.getWorkouts().size());
        x.removeAllWorkouts();
        assertEquals(0, x.getWorkouts().size()); //size 0 signifies that workout arraylist got cleared of workouts
    }

    public void testTestEquals() {
        assertTrue(x.equals(x)); //x is equal to itself
        y = new Routine("sundays", "hard", list);
        assertTrue(x.equals(y)); //x is equal to y consisting of the same exact workout object
        z = new Routine("mondays", "hard", list);
        assertFalse(x.equals(z)); //x is not equal to z due to a different name

    }
}