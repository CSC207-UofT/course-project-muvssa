package com.example.fitappa.Presenter;


import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.Gateway.ExerciseRepository;

import java.util.ArrayList;

public class AddExercisePresenter {
    private ExerciseRepository exRep;
    private View view;

    public AddExercisePresenter(View view) {
        this.view = view;
        exRep = new ExerciseRepository();
    }

    public void init() {
        view.loadExercise(exRep.getExercises());
    }

    // Dependency Inversion
    public interface View
    {
        void loadExercise(ArrayList<Exercise> e);
    }

}
