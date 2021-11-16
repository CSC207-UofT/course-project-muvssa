package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.WeightedRepExercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;

public class ViewWorkoutPresenter {
    View view;
    Workout workout;

    /**
     * View of the workouts
     * @param view represents how the user sees the workouts as type View
     * @param workout represents the workout as type Workout
     */
    public ViewWorkoutPresenter(View view, Workout workout) {
        this.workout = workout;
        this.view = view;
    }

    /**
     * Adds an exercise to the workout and updates the view of the exercises
     * @param exName represents the name of the exercise as type String
     */
    public void addExercise(String exName) {
        WeightedRepExercise e = new WeightedRepExercise(exName);
        workout.addExercise(e);
        view.updateExerciseLayout(e);
    }


    // Dependency Inversion
    public interface View
    {
        void updateExerciseLayout(Exercise e);
    }

}
