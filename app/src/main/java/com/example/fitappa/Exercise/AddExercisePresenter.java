package com.example.fitappa.Exercise;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.io.Serializable;
import java.util.List;

public class AddExercisePresenter {
    private final String PAGE_TITLE = "Add Exercise To Workout";
    private final View view;
    private final WorkoutTemplate workoutTemplate;
    private final List<ExerciseTemplate> exercises;
    //private final ExerciseGateway gateway;

    public AddExercisePresenter(View view, Serializable workoutTemplate, Serializable exercises) {
        this.view = view;
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.workoutTemplate = (WorkoutTemplate) workoutTemplate;
        this.exercises = (List<ExerciseTemplate>) exercises;
        this.view.displayExercises(this.exercises);

    }


    interface View {
        void updateAppBarTitle(String title);
        void displayExercises(List<ExerciseTemplate> e);

    }
}
