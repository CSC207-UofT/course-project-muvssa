package com.example.fitappa.Routine;

import com.example.fitappa.Workout.Core.WorkoutTemplate;
import junit.framework.TestCase;

import java.util.ArrayList;

public class RoutineTest extends TestCase {
    Routine x;
    WorkoutTemplate workoutTemplate;

    public void setUp() throws Exception {
        workoutTemplate = new WorkoutTemplate("chest");
        x = new Routine("sundays");
        super.setUp();
    }

    public void testTestGetName() {
        assertEquals("sundays", x.getName());
    }

    public void testTestSetName() {
        x.setName("o");
        assertEquals("o", x.getName());
    }




    public void testGetWorkouts() {
        x.addWorkout(workoutTemplate);
        assertTrue(x.getWorkouts().contains(workoutTemplate));
    }

    public void testSetWorkouts() {
        WorkoutTemplate workoutTemplate1 = new WorkoutTemplate("legs");
        ArrayList<WorkoutTemplate> workoutTemplates = new ArrayList<>();
        workoutTemplates.add(workoutTemplate);
        workoutTemplates.add(workoutTemplate1);
        x.setWorkouts(workoutTemplates);
        assertEquals(2, x.getWorkouts().size());
    }

    public void testAddWorkout() {
    }

    public void testRemoveWorkout() {
        x.addWorkout(workoutTemplate);
        assertEquals(1, x.getWorkouts().size());
        x.removeWorkout(workoutTemplate.getName());
        assertEquals(0, x.getWorkouts().size());
    }

    public void testRemoveAllWorkouts() {
        x.addWorkout(workoutTemplate);
        assertEquals(1, x.getWorkouts().size());
        x.removeAllWorkouts();
        assertEquals(0, x.getWorkouts().size());
    }

    public void testTestEquals() {
    }
}