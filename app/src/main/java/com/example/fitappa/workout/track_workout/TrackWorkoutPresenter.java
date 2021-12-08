package com.example.fitappa.workout.track_workout;

import com.example.fitappa.profile.Saveable;
import com.example.fitappa.workout.workout_template.WorkoutTemplate;

import java.io.Serializable;

/**
 * Presenter for TrackWorkout
 * <p>
 * Methods move information to the back end from the TrackWorkoutActivity and vice versa
 *
 * @author abdullah
 * @version 0.1
 * @layer Presenter (Third)
 */
class TrackWorkoutPresenter {
    private final View view;
    private final PerformWorkout performWorkout;

    /**
     * Constructor for TrackWorkoutPresenter
     *
     * @param view     reps the view
     * @param template reps the workout template
     */
    TrackWorkoutPresenter(View view, Serializable template) {

        WorkoutTemplate workoutTemplate = (WorkoutTemplate) template;
        this.view = view;
        this.performWorkout = new PerformWorkout(workoutTemplate);
        this.initializePage(this.performWorkout);
        this.performWorkout.start();
    }

    /**
     * This method initializes the view
     *
     * @param workout represents the workout
     */
    private void initializePage(PerformWorkout workout) {
        this.view.populateLayout(workout);
        this.view.updateTitle(workout.getName());

        final String PAGE_TITLE = "Start Workout";
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupCancel();
        this.view.setupEnd();
    }

    /**
     * This method adds a set to the workout being performed
     */
    void addSet(String identifier, int reps) {
        this.performWorkout.addSet(identifier, reps);
    }

    void finishWorkout() {
        this.performWorkout.finish();

        Saveable gateway = new SavePerformWorkouts();
        gateway.save(performWorkout.toString());


        this.view.exit();
    }

    /**
     * This method adds a set to the workout being performed
     */
    void addSet(String identifier, int weight, int reps) {
        this.performWorkout.addSet(identifier, weight, reps);
    }


    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);

        void updateTitle(String workoutTitle);

        void populateLayout(PerformWorkout workout);

        void setupCancel();

        void setupEnd();

        void exit();
    }
}
