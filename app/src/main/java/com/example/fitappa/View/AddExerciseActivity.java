package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.AddExercisePresenter;
import com.example.fitappa.R;

import java.io.Serializable;
import java.util.ArrayList;


public class AddExerciseActivity extends AppCompatActivity implements AddExercisePresenter.View {

    private AddExercisePresenter presenter;
    private LinearLayout exerciseLayout;
    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        this.workout = (Workout) getIntent().getSerializableExtra("workoutObj");

        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        this.presenter = new AddExercisePresenter(this);


        presenter.init();

    }

    public void updateExerciseLayout(Exercise e) {
        Button button = new Button(this);
        button.setText(e.getName());
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                goBackToWorkout(e.getName());
            }
        });

        exerciseLayout.addView(button);

    }

    @Override
    public void loadExercise(ArrayList<Exercise> e) {
        for (Exercise i : e) {
            updateExerciseLayout(i);
        }
    }

    public void goBackToWorkout(String e)
    {
        Intent w = new Intent(this, ViewWorkoutActivity.class);
        w.putExtra("workoutObj", (Serializable) this.workout);
        w.putExtra("exerciseName", e);
        setResult(RESULT_OK, w);
        finish();
    }


}