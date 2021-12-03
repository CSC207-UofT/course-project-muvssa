package com.example.fitappa.Exercise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.R;
import com.example.fitappa.Workout.ViewWorkoutActivity;
import com.example.fitappa.Workout.WorkoutTemplate;

import java.util.List;
import java.util.Objects;


public class AddExerciseActivity extends AppCompatActivity {

    private LinearLayout exerciseLayout;
    private WorkoutTemplate workoutTemplate;
    private List<ExerciseTemplate> exerciseTemplates;

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

        Button addExerciseBtn = findViewById(R.id.createExercise);

        this.workoutTemplate = (WorkoutTemplate) getIntent().getSerializableExtra("workoutObj");
        this.exerciseTemplates = (List<ExerciseTemplate>) getIntent().getSerializableExtra("exercises");

        this.exerciseLayout = findViewById(R.id.ExerciseLayout);

        addExerciseBtn.setOnClickListener(v -> openCreateNewExercise());

        displayExercises();
    }

    /**
     * Go to Create New Exercise Activity
     */
    private void openCreateNewExercise() {
        Intent addNewExercise = new Intent(this, CreateNewExerciseActivity.class);
        startActivity(addNewExercise);
    }

    /**
     * This method displays all the exercises and updates it in the
     * ExerciseLayout view component.
     */
    private void displayExercises() {
        for (ExerciseTemplate exerciseTemplate : this.exerciseTemplates) {
            updateExerciseLayout(exerciseTemplate);
        }
    }

    /**
     * This method updates the ExerciseLayout view component on AddExerciseActivity
     * by adding the Exercise to the layout.
     *
     * @param exerciseTemplate represents the Exercise object to add to the ExerciseLayout
     */
    private void updateExerciseLayout(ExerciseTemplate exerciseTemplate) {
        Button button = new Button(this);
        button.setText(exerciseTemplate.getName());
        button.setOnClickListener(view -> goBackToWorkout(exerciseTemplate));

        exerciseLayout.addView(button);
    }

    /**
     * This method opens the ViewWorkoutActivity view.
     *
     * @param exerciseTemplate represents the exercise to be returned to ViewWorkoutActivity
     */
    private void goBackToWorkout(ExerciseTemplate exerciseTemplate) {
        Intent viewWorkout = new Intent(this, ViewWorkoutActivity.class);
        viewWorkout.putExtra("workoutObj", this.workoutTemplate);
        viewWorkout.putExtra("exercise", exerciseTemplate);
        setResult(RESULT_OK, viewWorkout);
        finish();
    }
}