package com.example.fitappa.Workout;

public class WorkoutLogPresenter {
    View view;

    public WorkoutLogPresenter(View view) {
        this.view = view;



        this.inititalizeView();
    }

    void inititalizeView() {

    }

    interface View {
        void init();
        void updateAppBarTitle(String title);
    }
}
