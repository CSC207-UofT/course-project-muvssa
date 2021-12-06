package com.example.fitappa.Exercise;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;

import java.io.Serializable;
import java.util.List;

public class AddExercisePresenter {
    private final View view;
    private final List<ExerciseTemplate> exercises; // The global exercises

    /**
     * Constructor on AddExercisePresenter
     * @param view view
     * @param exercises exercises
     */
    public AddExercisePresenter(View view, Serializable exercises) {
        this.view = view;
        this.exercises = (List<ExerciseTemplate>) exercises; // from the db
        init();
    }


    /**
     * initializes the page
     */
    private void init() {
        String PAGE_TITLE = "Add Exercise To Workout";
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.displayExercises(this.exercises);
    }

    interface View {
        void updateAppBarTitle(String title);
        void displayExercises(List<ExerciseTemplate> e);
    }
}
