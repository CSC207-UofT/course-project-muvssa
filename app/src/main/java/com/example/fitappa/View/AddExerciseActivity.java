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

    /**
     * This method is called when the activity starts.
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        this.workout = (Workout) getIntent().getSerializableExtra("workoutObj");
        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        /* Make this a class variable once the conditions are met */
        AddExercisePresenter presenter = new AddExercisePresenter(this);
        presenter.init();

    }

    /**
     * This method loads all the Workout's exercises and updates it in the
     * ExerciseLayout view component.
     * @param exercises represents the Exercise objects stored in the Workout
     */
    @Override
    public void loadExercise(ArrayList<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            updateExerciseLayout(exercise);
        }
    }

    /**
     * This method updates the ExerciseLayout view component on AddExerciseActivity
     * by adding the Exercise, e, to the layout.
     * @param exercise represents the Exercise object to add to the ExerciseLayout
     */
    private void updateExerciseLayout(Exercise exercise) {
        Button button = new Button(this);
        button.setText(exercise.getName());
        button.setOnClickListener(view -> goBackToWorkout(exercise.getName()));

        exerciseLayout.addView(button);
    }

    /**
     * This method opens the ViewWorkoutActivity view. 
     * @param exerciseName represents the name of the exercise. 
     */
    private void goBackToWorkout(String exerciseName) {
        Intent viewWorkout = new Intent(this, ViewWorkoutActivity.class);
        viewWorkout.putExtra("workoutObj", this.workout);
        viewWorkout.putExtra("exerciseName", exerciseName);
        setResult(RESULT_OK, viewWorkout);
        finish();
    }
}