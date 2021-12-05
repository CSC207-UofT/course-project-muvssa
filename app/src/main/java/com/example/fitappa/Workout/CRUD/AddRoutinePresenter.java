package com.example.fitappa.Workout.CRUD;


import com.example.fitappa.Routine.LoadsRoutines;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;

import java.util.List;

class AddRoutinePresenter implements LoadsRoutines {
    private final String PAGE_TITLE = "Add Routine";
    private final View view;
    private final RoutinesGateway gateway;
    private String name;

    AddRoutinePresenter(View view) {
        this.view = view;
        this.gateway = new RoutinesGateway(this);
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddRoutineButton();
    }


    void addRoutine(String name) {
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
        if (name.length() == 0) {
            view.setError("Please enter a name");
        } else if (routines.size() >= 3) {
            view.setError("Unable to add routine. Please go back and remove a routine then try again");
        } else if (!isUniqueRoutineIn(name, routines)) {
            view.setError("Routine with the name \"" + name + "\" already exists");
        } else {
            routines.add(routine);
            gateway.save(routines);
            view.exitPage();
        }

    }

    /**
     * Checks to see if the given name represents a unique routine name in the given routines
     * list
     *
     * @param name     String name of the routine to check uniqueness for
     * @param routines List of routines to check if the routine is unique
     * @return true iff the name represents a unique routine in the routines list
     */
    private boolean isUniqueRoutineIn(String name, List<Routine> routines) {
        for (Routine routine : routines) {
            if (routine.getName().equals(name))
                return false;
        }
        return true;
    }

    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);

        void setupAddRoutineButton();

        void exitPage();

        /**
         * Set an error for the routine name text field with a given error message
         *
         * @param message String error message to display for the routine text
         */
        void setError(String message);
    }
}
