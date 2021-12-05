package com.example.fitappa.Workout.CRUD;

public class AddWorkoutPresenter {
    private final String PAGE_TITLE = "Add Workout";
    private View view;

    public AddWorkoutPresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddWorkoutButton();
    }


    public void addWorkoutTemplate(String name) {
        // TODO @uthman this is where the save workout template will happen

        view.exitPage();
    }


    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);
        void setupAddWorkoutButton();
        void exitPage();
    }
}
