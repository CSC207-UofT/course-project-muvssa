package com.example.fitappa.workout.workout_log;

import com.example.fitappa.profile.Loadable;

import java.util.List;

/**
 * Presenter for WorkoutLogActivity
 * <p>
 * Methods move information to the back end from the WorkoutLogActivity and vice versa
 *
 * @author abdullah
 * @version 0.3
 * @layer Presenter (Third)
 */

class WorkoutLogPresenter {
    private final View view;

    /**
     * Initializes the gateway and title update
     *
     * @param view represents TrackWorkoutActivity
     */
    WorkoutLogPresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle("Your Workout Logs");


        Loadable gateway = new LoadPerformWorkouts(this);
        gateway.load();
    }

    /**
     * initializes text on screen in the activity
     *
     * @param performWorkoutStrings list of performed workout names
     */
    void initializeView(List<String> performWorkoutStrings) {
        this.view.displayLog(performWorkoutStrings);
    }

    interface View {

        /**
         * Updates the title of the page
         *
         * @param title String representing the title
         */
        void updateAppBarTitle(String title);

        /**
         * displays workout logs on the page
         *
         * @param logs a list of strings representing a workout
         */
        void displayLog(List<String> logs);
    }
}
