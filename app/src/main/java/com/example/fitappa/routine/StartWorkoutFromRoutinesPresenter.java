package com.example.fitappa.routine;

import com.example.fitappa.profile.Loadable;

import java.util.List;

/**
 * Presenter class for StartWorkoutFromRoutinesActivity, send and receive information from the back end to help StartWorkoutFromRoutinesActivity
 * <p>
 * The method in the class moves the information to the back end and from it too
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 */
class StartWorkoutFromRoutinesPresenter implements LoadsRoutines {
    private final View view;

    /**
     * Constructor for StartWorkoutFromRoutinesPresenter
     *
     * @param view Activity
     */
    StartWorkoutFromRoutinesPresenter(View view) {
        this.view = view;
        Loadable gateway = new RoutinesGateway(this);

        gateway.load();
        String PAGE_TITLE = "Start Workout";
        view.updateAppBarTitle(PAGE_TITLE);
        view.initializeAddRoutine();
    }

    @Override
    public void loadRoutines(List<Routine> routines) {
        view.displayRoutines(routines);
    }

    /**
     * View interface
     */
    interface View {
        void displayRoutines(List<Routine> routines);

        void updateAppBarTitle(String title);

        void initializeAddRoutine();
    }

}
