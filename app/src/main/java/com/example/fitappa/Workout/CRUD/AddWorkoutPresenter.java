package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Workout.Core.LoadsWorkoutTemplates;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplatesGateway;

import java.io.Serializable;
import java.util.List;

/**
 * This class is the presenter for AddWorkoutActivity
 * <p>
 * Methods in this class move information from the activity to the backend and vice versa
 * <p>
 * Documentation specifies what the methods do
 *
 * @author Abdullah
 * @since 1.2
 */

class AddWorkoutPresenter implements LoadsWorkoutTemplates {
    private final WorkoutTemplatesGateway gateway;
    private final View view;
    private String workoutName;

    AddWorkoutPresenter(View view, Serializable routineName) {
        this.view = view;
        this.gateway = new WorkoutTemplatesGateway(this, (String) routineName);
        String PAGE_TITLE = "Add Workout";
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddWorkoutButton();
    }

    /**
     * Take in a string representing a workout name and load the workout templates from the gateway
     * to try and add the workout template to the list
     *
     * @param name String representing the name of the workout to attempt to add to the list
     */
    void addWorkoutTemplate(String name) {
        workoutName = name;
        gateway.load();
    }

    /**
     * Load templates from the gateway and attempt to add a workout template to it
     *
     * @param workoutTemplates List of WorkoutTemplate which is retrieved from the gateway
     */
    @Override
    public void loadWorkoutTemplates(List<WorkoutTemplate> workoutTemplates) {

        if (workoutName.length() == 0) {
            view.setError("Please enter a name");
        } else if (workoutTemplates.size() >= 3) {
            view.setError("Too many workouts!. Unable to add. Please go back and remove a routine then try again");
        } else if (!isUniqueWorkoutTemplateIn(workoutName, workoutTemplates)) {
            view.setError("Workout with the name \"" + workoutName + "\" already exists");
        } else {
            WorkoutTemplate workoutTemplate = new WorkoutTemplate(workoutName);
            workoutTemplates.add(workoutTemplate);
            gateway.save(workoutTemplates);
            view.exitPage();
        }
    }

    /**
     * Checks to see if the given name represents a unique routine name in the given routines
     * list
     *
     * @param name             String name of the routine to check uniqueness for
     * @param workoutTemplates List of routines to check if the routine is unique
     * @return true iff the name represents a unique routine in the routines list
     */
    private boolean isUniqueWorkoutTemplateIn(String name, List<WorkoutTemplate> workoutTemplates) {
        for (WorkoutTemplate workoutTemplate : workoutTemplates) {
            if (workoutTemplate.getName().equals(name))
                return false;
        }
        return true;
    }

    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);

        void setupAddWorkoutButton();

        void exitPage();

        /**
         * Set an error for the workout name text field with a given error message
         *
         * @param message String error message to display for the workout name text
         */
        void setError(String message);
    }
}
