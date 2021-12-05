package com.example.fitappa.Workout.CRUD;


public class AddRoutinePresenter {
    private final String PAGE_TITLE = "Add Routine";
    private View view;

    public AddRoutinePresenter(View view) {
        this.view = view;

        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddRoutineButton();
    }


    public void addRoutine(String name) {
        // TODO @uthman this is where the save routine will happen

        view.exitPage();
    }


    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);
        void setupAddRoutineButton();
        void exitPage();
    }
}
