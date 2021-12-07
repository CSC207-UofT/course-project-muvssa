package com.example.fitappa.Workout.CRUD;


import com.example.fitappa.Routine.LoadsRoutines;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;

import java.util.List;

/**
 * This class is the presenter for AddRoutineActivity
 *
 * Methods in this class move information from the activity to the backend and vice versa
 *
 * Documentation specifies what the methods do
 *
 * @author Abdullah
 *
 * @since 0.2
 */

class AddRoutinePresenter implements LoadsRoutines {
    private final View view;
    private final RoutinesGateway gateway;
    private String name;

    /**
     * initializes the presenter by connecting it to the gateway and initializing buttons and title of the activity
     * @param view represents AddRoutineActivity
     */
    AddRoutinePresenter(View view) {
        this.view = view;
        this.gateway = new RoutinesGateway(this);

        String PAGE_TITLE = "Add Routine";
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddRoutineButton();
    }


    /**
     * Take in a string representing a routine name and load the routines to try and add the routine
     * to the list
     *
     * @param name String representing the name of the routine to attempt to add to the list
     */
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
        if (name.length() == 0) {
            view.setError("Please enter a name");
        } else if (routines.size() >= 3) {
            view.setError("Too many routines! Unable to add. Please go back and remove a routine then try again");
        } else if (!isUniqueRoutineIn(name, routines)) {
            view.setError("Routine with the name \"" + name + "\" already exists");
        } else {
            Routine routine = new Routine(name);
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
