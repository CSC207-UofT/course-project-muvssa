package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Routine.LoadsRoutines;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Presenter class for StartWorkoutActivity, send and receive information from the back end to help StartWorkoutActivity
 * <p>
 * The method in the class moves the information to the back end and from it too
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 */
public class StartWorkoutPresenter implements LoadsRoutines {
    private final View view;
    private final String PAGE_TITLE = "Start Workout";
    private final Loadable gateway;
    private Routine currRoutine;
    private final List<Routine> routines;

    /**
     * Constructor for StartWorkoutPresenter
     *
     * @param view
     */
    public StartWorkoutPresenter(View view) {
        this.view = view;
        this.routines = new ArrayList<>();
        this.gateway = new RoutinesGateway(this);
        // don't remove this!
        gateway.load();
        view.updateAppBarTitle(this.PAGE_TITLE);
        view.initializeAddRoutine();
    }

    @Override
    public void loadRoutines(List<Routine> routines) {
        view.displayRoutines(routines);
    }

    /**
     * sets current routine
     *
     * @param r current routine
     */
    public void setCurrentRoutine(Routine r) {
        this.currRoutine = r;
    }

    /**
     * Adds workout to routine
     *
     * @param workoutName represents the workout
     */
    public void addWorkoutToRoutine(String workoutName) {
        this.currRoutine.addWorkout(new WorkoutTemplate(workoutName));

        // TODO @uthman save routine here

        this.view.displayRoutines(this.routines);
    }

    /**
     * View interface
     */
    interface View {
        void updateRoutinesView(Routine routines);

        void displayRoutines(List<Routine> routines);

        void updateAppBarTitle(String title);

        void initializeAddRoutine();
    }

}
