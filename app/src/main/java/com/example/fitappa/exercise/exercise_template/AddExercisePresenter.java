package com.example.fitappa.exercise.exercise_template;

import java.io.Serializable;
import java.util.List;

class AddExercisePresenter {
    private final View view;
    private final List<ExerciseTemplate> exercises; // The global exercises

    /**
     * Constructor on AddExercisePresenter
     *
     * @param view      view
     * @param exercises exercises
     */
    @SuppressWarnings("unchecked")
    AddExercisePresenter(View view, Serializable exercises) {
        this.view = view;
        this.exercises = (List<ExerciseTemplate>) exercises;
        init();
    }


    /**
     * initializes the page
     */
    private void init() {
        String PAGE_TITLE = "Add exercise To Workout";
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.displayExercises(this.exercises);
    }

    interface View {
        void updateAppBarTitle(String title);

        void displayExercises(List<ExerciseTemplate> e);
    }
}
