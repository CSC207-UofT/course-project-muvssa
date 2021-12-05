package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.util.ArrayList;
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
    private final View view;
    private final String PAGE_TITLE = "Start Workout";
    private Routine currRoutine;
    private final List<Routine> routines;
    private final Loadable gateway;


    // TODO: (For uthman), populate routines list

    /**
     * Constructor for StartWorkoutPresenter
     *
     * @param view
     */
    public StartWorkoutPresenter(View view) {
        this.view = view;
        this.routines = new ArrayList<>();
        this.gateway = new RoutinesGateway(this);

        // Dummy data! Replace me with gateway call when gateway is finished
        Routine r = new Routine("MMA routine");
        WorkoutTemplate w = new WorkoutTemplate("High Intensity");
        ExerciseTemplate e1 = new ExerciseTemplate("Go crazy (Rep)", 0, "REP");
        ExerciseTemplate e2 = new ExerciseTemplate("Go wild (Rep)", 0, "REP");
        w.addExercise(e1);
        w.addExercise(e2);
        r.addWorkout(w);
        routines.add(r);
        this.currRoutine = r;

        // don't remove this!
        view.displayRoutines(this.routines);
        view.updateAppBarTitle(this.PAGE_TITLE);
        view.initializeAddRoutine();

        // TODO: @Abdullah does this go here?
        gateway.load();
    }

    public void doSomethingWithRoutines(List<Routine> routines) {
        // TODO: @Abdullah refactor this method name and have it do what you need
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
