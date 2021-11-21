package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Presenter.AddExercisePresenter;
import com.example.fitappa.R;

import java.util.ArrayList;


public class AddExerciseActivity extends AppCompatActivity implements AddExercisePresenter.View {

    private LinearLayout exerciseLayout;
    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        this.workout = (Workout) getIntent().getSerializableExtra("workoutObj");

        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        AddExercisePresenter presenter = new AddExercisePresenter(this);

        presenter.init();

    }

    @Override
    public void loadExercise(ArrayList<Exercise> e) {
        for (Exercise i : e) {
            updateExerciseLayout(i);
        }
    }

    private void updateExerciseLayout(Exercise e) {
        Button button = new Button(this);
        button.setText(e.getName());
        button.setOnClickListener(view -> goBackToWorkout(e.getName()));

        exerciseLayout.addView(button);
    }

    private void goBackToWorkout(String e) {
        Intent w = new Intent(this, ViewWorkoutActivity.class);
        w.putExtra("workoutObj", this.workout);
        w.putExtra("exerciseName", e);
        setResult(RESULT_OK, w);
        finish();
    }
}