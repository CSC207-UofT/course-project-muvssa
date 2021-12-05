package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.util.List;

/**
 * Presenter class for StartWorkoutActivity, send and receive information from the back end to help StartWorkoutActivity
 *
 * The method in the class moves the information to the back end and from it too
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 */
public class StartWorkoutPresenter {
    private final Profile profile;
    private View view;
    private Routine currRoutine;

    /**
     * Constructor for StartWorkoutPresenter
     * @param view
     * @param profile
     */
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

    /**
     * sets current routine
     * @param r current routine
     */
    public void setCurrentRoutine(Routine r) {
        this.currRoutine = r;
    }

    /**
     * Adds workout to routine
     * @param workoutName represents the workout
     */
    public void addWorkoutToRoutine(String workoutName) {
        this.currRoutine.addWorkout(new WorkoutTemplate(workoutName));
        this.view.init(this.profile.getRoutines());
    }

    /**
     * View interface
     */
    interface View {
        void updateRoutinesView(Routine routines);
        void init(List<Routine> routines);
    }

}
