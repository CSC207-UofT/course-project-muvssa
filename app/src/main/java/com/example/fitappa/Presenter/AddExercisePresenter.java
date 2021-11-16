package com.example.fitappa.Presenter;


import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Gateway.ExerciseRepository;

import java.util.ArrayList;

public class AddExercisePresenter {
    private final ExerciseRepository exRep;
    private final View view;

    /**
     * Update exercise repository
     *
     * @param view type view that represents the view of the exercise that will be seen by the user
     */
    public AddExercisePresenter(View view) {
        this.view = view;
        exRep = new ExerciseRepository();
    }

    /**
     * Initialize an exercise from the view of the exercise
     */
    public void init() {
        view.loadExercise(exRep.getExercises());
    }

    // Dependency Inversion
    public interface View {
        void loadExercise(ArrayList<Exercise> e);
    }

}
