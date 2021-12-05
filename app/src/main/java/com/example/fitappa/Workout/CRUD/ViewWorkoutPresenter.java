package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

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
    private final WorkoutTemplate workoutTemplate;

    /**
     * View of the workouts
     *
     * @param view    represents how the user sees the workouts as type View
     * @param workoutTemplate represents the workout as type Workout
     */
    ViewWorkoutPresenter(View view, WorkoutTemplate workoutTemplate) {
        this.workoutTemplate = workoutTemplate;
        this.view = view;

        // initialize view
        for(ExerciseTemplate e : workoutTemplate.getExercises()) {
            view.updateExerciseLayout(e);
        }

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

    /**
     * Updates profile with the new routine and sends you back to ViewRoutineActivity
     */
    void updateWorkoutRoutine() {
        /*List<WorkoutTemplate> workoutTemplates = routine.getWorkouts();
        int pos = workoutTemplates.indexOf(workoutTemplate);
        workoutTemplates.set(pos, workoutTemplate);*/

        view.goBack();

    }


    // Dependency Inversion
    interface View {
        void updateExerciseLayout(ExerciseTemplate e);

        void goBack();
    }

}
