package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Loadable;

import java.util.List;

public class WorkoutLogPresenter {
    View view;

    public WorkoutLogPresenter(View view) {
        this.view = view;

        Loadable gateway = new LoadPerformWorkouts(this);
        gateway.load();

        this.view.updateAppBarTitle("Your workout logs");

    }

    void inititalizeView(List<String> performWorkoutStrings) {

    }

    interface View {
        void init();
        void updateAppBarTitle(String title);
    }
}
