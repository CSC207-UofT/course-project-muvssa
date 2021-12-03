package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Routine.Routine;
import java.util.List;

public class StartWorkoutPresenter {
    private final Profile profile;
    private View view;
    private Routine currRoutine;

    public StartWorkoutPresenter(View view, Profile profile) {
        this.profile = profile;
        this.view = view;

    }

    /**
     * Adds a routine the the user's profile and updates the view of the routines
     *
     * @param name represents the name of the routine as type String
     */
    void addRoutine(String name) {
        Routine r = new Routine(name);
        this.profile.addRoutine(r);
        view.updateRoutinesView(r);

        // TODO: save to database using gateway

    }

    public void setCurrentRoutine(Routine r) {
        this.currRoutine = r;
    }

    public void addWorkoutToWorkout(String workoutName) {
        this.currRoutine.addWorkout(new WorkoutTemplate(workoutName));
        this.view.init(this.profile.getRoutines());
    }

    interface View {
        void updateRoutinesView(Routine routines);
        void init(List<Routine> routines);
    }

}
