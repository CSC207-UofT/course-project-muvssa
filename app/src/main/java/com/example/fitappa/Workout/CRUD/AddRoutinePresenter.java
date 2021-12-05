package com.example.fitappa.Workout.CRUD;


import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;

import java.util.List;

public class AddRoutinePresenter {
    private final String PAGE_TITLE = "Add Routine";
    private final View view;
    private final RoutinesGateway gateway;

    public AddRoutinePresenter(View view) {
        this.view = view;
        this.gateway = new RoutinesGateway(this);
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddRoutineButton();
    }


    public void addRoutine(String name) {
        // TODO @uthman this is where the save routine will happen

        Routine routine = new Routine(name);

        gateway.save(routine);

        view.exitPage();
    }

    // TODO @Abdullah
    public void doSomethingWithRoutines(List<Routine> routines) {
        // Currently being called from gateway. Refactor and change name to whatever needs to
        // be done.
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
