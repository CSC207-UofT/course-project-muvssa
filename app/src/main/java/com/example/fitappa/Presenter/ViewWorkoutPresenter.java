package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.WeightedRepExercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;

import java.util.ArrayList;
import java.util.List;

public class ViewWorkoutPresenter {
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
    public ViewWorkoutPresenter(View view, Workout workout, Routine routine) {
        this.workout = workout;
        this.view = view;
        this.routine = routine;
    }

    /**
     * Adds an exercise to the workout and updates the view of the exercises
     *
     * @param exName represents the name of the exercise as type String
     */
    public void addExercise(String exName) {
        WeightedRepExercise e = new WeightedRepExercise(exName);
        workout.addExercise(e);
        view.updateExerciseLayout(e);
    }

    /**
     * Updates profile with the new routine and sends you back to ViewRoutineActivity
     */
    public void updateWorkoutRoutine() {
        List<Workout> workouts = routine.getWorkouts();
        int pos = workouts.indexOf(workout);
        workouts.set(pos, workout);
        routine.setWorkouts((ArrayList<Workout>) workouts);
        view.goBackToViewRoutine();

    }


    // Dependency Inversion
    public interface View {
        void updateExerciseLayout(Exercise e);

        void goBackToViewRoutine();
    }

}
