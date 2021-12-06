package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Workout.Core.LoadsWorkoutTemplates;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplatesGateway;

import java.io.Serializable;
import java.util.List;

public class AddWorkoutPresenter implements LoadsWorkoutTemplates {
    private final String PAGE_TITLE = "Add Workout";
    private final WorkoutTemplatesGateway gateway;
    private final View view;
    private String workoutName;

    public AddWorkoutPresenter(View view, Serializable routineName) {
        this.view = view;
        this.gateway = new WorkoutTemplatesGateway(this, (String) routineName);
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupAddWorkoutButton();
    }


    public void addWorkoutTemplate(String name) {
        // TODO @uthman this is where the save workout template will happen

        workoutName = name;
        gateway.load();
    }

    @Override
    public void loadWorkoutTemplates(List<WorkoutTemplate> templates) {
        WorkoutTemplate workoutTemplate = new WorkoutTemplate(workoutName);
        templates.add(workoutTemplate);
        gateway.save(templates);
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
