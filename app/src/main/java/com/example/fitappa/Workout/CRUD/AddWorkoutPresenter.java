package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Workout.Core.LoadsWorkoutTemplates;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplatesGateway;

import java.io.Serializable;
import java.util.List;

public class AddWorkoutPresenter {
    private final String PAGE_TITLE = "Add Workout";
    private View view;
    private final WorkoutTemplatesGateway gateway;

    public AddWorkoutPresenter(View view, Serializable routineName) {
        this.view = view;
        this.gateway = new WorkoutTemplatesGateway(this, (String) routineName);
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
