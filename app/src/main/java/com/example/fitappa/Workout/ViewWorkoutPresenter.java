package com.example.fitappa.Workout;

import com.example.fitappa.Exercise.Exercise;
import com.example.fitappa.Routine.Routine;

import java.util.ArrayList;
import java.util.List;

class ViewWorkoutPresenter {
    private final View view;
    private final Workout workout;
    private final Routine routine;

    /**
     * View of the workouts
     *
     * @param view    represents how the user sees the workouts as type View
     * @param workout represents the workout as type Workout
     * @param routine represents the routine as type Routine
     */
    ViewWorkoutPresenter(View view, Workout workout, Routine routine) {
        this.workout = workout;
        this.view = view;
        this.routine = routine;
    }

    /**
     * Adds an exercise to the workout and updates the view of the exercises
     *
     * @param exercise represents the exercise to be added
     */
    void addExercise(Exercise exercise) {
        workout.addExercise(exercise);
        view.updateExerciseLayout(exercise);
    }

    /**
     * Updates profile with the new routine and sends you back to ViewRoutineActivity
     */
    void updateWorkoutRoutine() {
        List<Workout> workouts = routine.getWorkouts();
        int pos = workouts.indexOf(workout);
        workouts.set(pos, workout);
        routine.setWorkouts((ArrayList<Workout>) workouts);
        view.goBackToViewRoutine();

    }


    // Dependency Inversion
    interface View {
        void updateExerciseLayout(Exercise e);

        void goBackToViewRoutine();
    }

}
