package com.example.fitappa.Routine;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Workout.WorkoutTemplate;

import java.util.List;

class ViewRoutinePresenter {
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
    public ViewRoutinePresenter(View view, Routine routine, Profile profile) {
        this.view = view;
        this.routine = routine;
        this.profile = profile;

    }

    /**
     * Adds a workout to the routine
     *
     * @param workoutName String of the name of the workout that a user wants to add to their routine
     */
    void addWorkout(String workoutName) {
        // TODO: Fix bug, apparently w1 is null.
        WorkoutTemplate w1 = new WorkoutTemplate(workoutName);
        this.routine.addWorkout(w1);
        view.updateRoutineView(w1);
    }

    /**
     * Updates profile with the new routine and sends you back
     */
    void updateProfileRoutine() {
        List<Routine> routines = profile.getRoutines();
        int pos = routines.indexOf(routine);
        routines.set(pos, routine);
        profile.setRoutines(routines);
        view.goBackToViewRoutines();

    }

    interface View {
        void updateRoutineView(WorkoutTemplate workoutTemplate);

        void goBackToViewRoutines();
    }
}
