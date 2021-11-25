package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.R;

import java.util.List;
import java.util.Objects;


public class AddExerciseActivity extends AppCompatActivity {

    private LinearLayout exerciseLayout;
    private Workout workout;
    private List<Exercise> exercises;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add Exercise");

        this.workout = (Workout) getIntent().getSerializableExtra("workoutObj");
        this.exercises = (List<Exercise>) getIntent().getSerializableExtra("exercises");

        this.exerciseLayout = findViewById(R.id.ExerciseLayout);

        displayExercises();
    }

    /**
     * This method displays all the exercises and updates it in the
     * ExerciseLayout view component.
     */
    private void displayExercises() {
        for (Exercise exercise : this.exercises) {
            updateExerciseLayout(exercise);
        }
    }

    /**
     * This method updates the ExerciseLayout view component on AddExerciseActivity
     * by adding the Exercise to the layout.
     *
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
     *
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