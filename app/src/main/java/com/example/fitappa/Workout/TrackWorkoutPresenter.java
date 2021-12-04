package com.example.fitappa.Workout;

import com.example.fitappa.Workout.Core.PerformWorkout;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.io.Serializable;

/**
 * Presenter for TrackWorkout
 *
 * @author abdullah
 * @version 0.1
 * @layer Presenter (Third)
 */
public class TrackWorkoutPresenter {
    private View view;
    private PerformWorkout performWorkout;
    private final String PAGE_TITLE = "Start Workout";

    public TrackWorkoutPresenter(View view, Serializable template) {

        WorkoutTemplate workoutTemplate = (WorkoutTemplate) template;
        this.view = view;
        this.performWorkout = new PerformWorkout(workoutTemplate);
        this.initializePage(this.performWorkout);
    }

    /**
     * This method initializes the view
     * @param workout represents the workout
     */
    public void initializePage(PerformWorkout workout) {
        this.view.populateLayout(workout);
        this.view.updateTitle(workout.getName());
        this.view.updateAppBarTitle(PAGE_TITLE);
    }

    /**
     * This method adds a set to the workout being performed
     */
    public void addSet(String identifier) {

    }


    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);
        void updateTitle(String workoutTitle);
        void populateLayout(PerformWorkout workout);
        //void addSetToExercise(String identifier);
    }
}
