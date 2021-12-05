package com.example.fitappa.Workout.CRUD;


import com.example.fitappa.Routine.LoadsRoutines;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;

import java.util.List;

public class AddRoutinePresenter implements LoadsRoutines {
    private final String PAGE_TITLE = "Add Routine";
    private final View view;
    private final RoutinesGateway gateway;
    private String name;

    public AddRoutinePresenter(View view) {
        this.view = view;
        this.gateway = new RoutinesGateway(this);
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddRoutineButton();
    }


    public void addRoutine(String name) {
        this.name = name;
        gateway.load();
    }

    /**
     * Called from gateway when gateway.load() is called to load the routines from database
     * and add the routine with the given name to the list of routines, then save them.
     *
     * @param routines List of routines received from the database
     */
    @Override
    public void loadRoutines(List<Routine> routines) {
        Routine routine = new Routine(name);
        routines.add(routine);
        gateway.save(routines);
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
