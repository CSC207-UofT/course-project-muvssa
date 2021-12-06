package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * This class is a presenter class  meant to send and receive information from the back end to help ViewWorkoutActivity
 *
 * The methods in this class help move information to and from the ViewWorkoutActivity class
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.3
 */

class ViewWorkoutPresenter {
    private final View view;
    private final WorkoutTemplate workoutTemplate; // TODO: @uthman, set the workout template once loaded
    private final String PAGE_TITLE = "View Your Workout";
    private final String routineName;

    /**
     * View of the workouts
     *
     * @param view    represents how the user sees the workouts as type View
     * @param workoutTemplate represents the workout as type Workout
     */
    ViewWorkoutPresenter(View view, Serializable workoutTemplate, Serializable routineName) {
        String workoutName = (String) workoutTemplate;
        this.routineName = (String) routineName;

        // TODO @uthman, load the workout with workoutName in the routine, routineName


        // Temporary solution:
        this.workoutTemplate = new WorkoutTemplate("h");

        this.view = view;
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.init();
    }

    public void init() {
        // initialize view
        for(ExerciseTemplate e : this.workoutTemplate.getExercises()) {
            view.updateExerciseLayout(e);
        }

        this.view.setupExerciseBtn();
        this.view.setTitle(this.workoutTemplate.getName() + "' exercises");
    }

    /**
     * Adds an exercise to the workout and updates the view of the exercises
     *
     * @param exerciseTemplate represents the exercise to be added
     */
    void addExercise(ExerciseTemplate exerciseTemplate) {
        workoutTemplate.addExercise(exerciseTemplate);
        view.updateExerciseLayout(exerciseTemplate);
    }

    // Dependency Inversion
    interface View {
        void updateAppBarTitle(String title);
        void updateExerciseLayout(ExerciseTemplate e);
        void setTitle(String name);
        void goBack();
        void setupExerciseBtn();
    }

}
