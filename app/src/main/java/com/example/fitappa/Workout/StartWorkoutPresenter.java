package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Routine.LoadsRoutines;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.RoutinesGateway;

import java.util.List;

/**
 * Presenter class for StartWorkoutActivity, send and receive information from the back end to help StartWorkoutActivity
 * <p>
 * The method in the class moves the information to the back end and from it too
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 */
public class StartWorkoutPresenter implements LoadsRoutines {
    private final View view;

    /**
     * Constructor for StartWorkoutPresenter
     *
     * @param view Activity
     */
    public StartWorkoutPresenter(View view) {
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
