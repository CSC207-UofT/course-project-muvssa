package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Loadable;

import java.util.List;

public class WorkoutLogPresenter {
    View view;

    public WorkoutLogPresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle("Your workout logs");


        Loadable gateway = new LoadPerformWorkouts(this);
        gateway.load();
    }

    void inititalizeView(List<String> performWorkoutStrings) {
        this.view.displayLog(performWorkoutStrings);
    }

    interface View {
        void updateAppBarTitle(String title);
        void displayLog(List<String>  logs);
    }
}
