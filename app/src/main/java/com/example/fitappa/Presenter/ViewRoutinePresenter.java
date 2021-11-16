package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;

public class ViewRoutinePresenter {
    private final Routine routine;
    private final View view;

    /**
     * Constructor for the view of the routine
     *
     * @param view    represents the view of the routine
     * @param routine represents the collection of workouts as type Routine
     */
    public ViewRoutinePresenter(View view, Routine routine) {
        this.view = view;
        this.routine = routine;
    }

    /**
     * Adds a workout to the routine
     *
     * @param workoutName String of the name of the workout that a user wants to add to their routine
     */
    public void addWorkout(String workoutName) {
        // TODO: Fix bug, apparently w1 is null.
        Workout w1 = new Workout(workoutName, "test");
        this.routine.addWorkout(w1);
        view.updateRoutineView(w1);
    }

    public interface View {
        void updateRoutineView(Workout workout);
    }
}
