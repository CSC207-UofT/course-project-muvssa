package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Loadable;

import java.util.List;

/**
 * Presenter for WorkoutLogActivity
 *
 * Methods move information to the back end from the WorkoutLogActivity and vice versa
 *
 * @author abdullah
 * @version 0.3
 * @layer Presenter (Third)
 */

public class WorkoutLogPresenter {
    View view;

    /**
     * Initializes the gateway and title update
     * @param view represents TrackWorkoutActivity
     */
    public WorkoutLogPresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle("Your workout logs");


        Loadable gateway = new LoadPerformWorkouts(this);
        gateway.load();
    }

    /**
     * initializes text on screen in the activity
     * @param performWorkoutStrings list of performed workout names
     */
    void inititalizeView(List<String> performWorkoutStrings) {
        this.view.displayLog(performWorkoutStrings);
    }

    interface View {

        /**
         * Updates the title of the page
         * @param title String representing the title
         */
        void updateAppBarTitle(String title);

        /**
         * displays workout logs on the page
         * @param logs a list of strings representing a workout
         */
        void displayLog(List<String>  logs);
    }
}
