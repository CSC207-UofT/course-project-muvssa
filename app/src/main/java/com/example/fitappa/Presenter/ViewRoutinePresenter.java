package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;

import java.util.List;

public class ViewRoutinePresenter {
    private final Routine routine;
    private final View view;
    private final Profile profile;

    /**
     * Constructor for the view of the routine
     *
     * @param view    represents the view of the routine
     * @param routine represents the collection of workouts as type Routine
     * @param profile represents the users profile
     */
    public ViewRoutinePresenter(View view, Routine routine,Profile profile) {
        this.view = view;
        this.routine = routine;
        this.profile = profile;

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
    /**
     * Updates profile with the new routine and sends you back
     *
     */
    public void updateProfileRoutine(){
        List<Routine> routines = profile.getRoutines();
        int pos = routines.indexOf(routine);
        routines.set(pos, routine);
        profile.setRoutines(routines);
        view.goBackToViewRoutines();

    }

    public interface View {
        void updateRoutineView(Workout workout);
        void goBackToViewRoutines();
    }
}
