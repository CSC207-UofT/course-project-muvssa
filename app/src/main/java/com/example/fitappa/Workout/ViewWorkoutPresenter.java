package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Routine.Routine;

import java.util.ArrayList;
import java.util.List;

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
