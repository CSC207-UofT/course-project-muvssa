package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.WeightedRepExercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;

public class ViewWorkoutPresenter {
    View view;
    Workout workout;


    public ViewWorkoutPresenter(View view, Workout workout) {
        this.workout = workout;
        this.view = view;
    }

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
