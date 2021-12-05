package com.example.fitappa.Workout.CRUD;


import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;

import java.util.List;

public class AddRoutinePresenter {
    private final String PAGE_TITLE = "Add Routine";
    private final View view;
    private final Saveable gateway;

    public AddRoutinePresenter(View view) {
        this.view = view;
        this.gateway = new RoutinesGateway();
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddRoutineButton();
    }


    public void addRoutine(String name) {
        // TODO @uthman this is where the save routine will happen

        Routine routine = new Routine(name);
        gateway.save(routine);
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
