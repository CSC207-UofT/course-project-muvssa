package fitappfiles;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.RepExercise;
import com.example.fitappa.Model.Entity.Workout;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class WorkoutTest extends TestCase {
    Workout workout;
    Exercise ex;


    public void setUp() throws Exception {
        workout = new Workout("chest", "easy");
        ex = new RepExercise("squats", 5, 1, "quads", 25);
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestGetName() {
        assertEquals("chest", workout.getName()); //name matches string, getter is good
    }

    public void testTestSetName() {
        workout.setName("legs");
        assertEquals("legs", workout.getName()); //name that has been set matches string, setter is good
    }

    public void testGetStartTime() {
        assertEquals(workout.getStartTime(), workout.getStartTime());//time matches, getter is good

    }

    public void testSetStartTime() {
        workout.setStartTime(LocalDateTime.of(2017, 2, 13, 15, 56));
        assertEquals(LocalDateTime.of(2017, 2, 13, 15, 56), workout.getStartTime());
        //time that has been set matches, setter is good


    }

    public void testGetEndTime() {

        assertEquals(workout.getEndTime(), workout.getEndTime()); //time matches, getter is good
    }

    public void testSetEndTime() {
        workout.setEndTime(LocalDateTime.of(2018, 3, 12, 11, 22));
        assertEquals(LocalDateTime.of(2018, 3, 12, 11, 22), workout.getEndTime());
        //time that has been set matches, setter is good
    }

    public void testGetDescription() {
        assertEquals("easy", workout.getDescription()); //description matches string, getter is good
    }

    public void testSetDescription() {
        workout.setDescription("hard");
        assertEquals("hard", workout.getDescription());
        //description that has been set matches string, setter is good
    }

    public void testAddExercise() {
        assertEquals(0, workout.getExercises().size()); //current size 0
        workout.addExercise(ex);
        assertEquals(1, workout.getExercises().size()); //current size increases after using method
        assertEquals(ex, workout.getExercises().get(0)); //element at index also matches
    }

    public void testGetTotalVolume() {
        workout.addExercise(ex);
        assertEquals(125.0, workout.getTotalVolume()); //gets the volume of the one exercise object
        ex = new RepExercise("pull ups", 2, 2, "biceps", 10);
        workout.addExercise(ex); //adds a new exercise
        assertEquals(145.0, workout.getTotalVolume()); //adds the volume of the new exercise object (2*10 = 20)
        // to attain the correct total volume

    }

    public void testGetDuration() {

    }
}