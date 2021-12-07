package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.io.Serializable;

/**
 * This class is a presenter class  meant to send and receive information from the back end to help ViewWorkoutActivity
 * <p>
 * The methods in this class help move information to and from the ViewWorkoutActivity class
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.3
 */

class ViewWorkoutPresenter implements LoadsWorkoutTemplate {
    private final View view;
    private final WorkoutTemplateGateway gateway;
    private WorkoutTemplate workoutTemplate;

    /**
     * View of the workouts
     *
     * @param view                represents how the user sees the workouts as type View
     * @param workoutTemplateName represents the workout as type WorkoutTemplate
     */
    ViewWorkoutPresenter(View view, Serializable workoutTemplateName, Serializable receivedRoutineName) {
        String workoutName = (String) workoutTemplateName;
        String routineName = (String) receivedRoutineName;

        this.view = view;
        String PAGE_TITLE = "View Your Workout";
        this.view.updateAppBarTitle(PAGE_TITLE);

        gateway = new WorkoutTemplateGateway(this, workoutName, routineName);
        gateway.load();
    }

    private void init() {
        // initialize view
        for (ExerciseTemplate e : this.workoutTemplate.getExercises()) {
            view.updateExerciseLayout(e);
        }
        this.view.setTitle(this.workoutTemplate.getName() + "'s exercises");
    }

    /**
     * Adds an exercise to the workout and updates the view of the exercises
     *
     * @param exerciseTemplate represents the exercise to be added
     */
    void addExercise(ExerciseTemplate exerciseTemplate) {
        workoutTemplate.addExercise(exerciseTemplate);
        gateway.save(workoutTemplate);
        view.updateExerciseLayout(exerciseTemplate);
    }

    @Override
    public void loadWorkoutTemplate(WorkoutTemplate workoutTemplate) {
        this.workoutTemplate = workoutTemplate;
        init();
    }

    // Dependency Inversion
    interface View {
        void updateAppBarTitle(String title);

        void updateExerciseLayout(ExerciseTemplate e);

        void setTitle(String name);
    }

}
