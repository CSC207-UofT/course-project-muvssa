package com.example.fitappa.workout.workout_template;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;
import com.example.fitappa.routine.StartWorkoutFromRoutinesActivity;

import java.util.Objects;

/**
 * This class is a view class meant to open the activity_create_workout xml, which allows users to create Workouts
 * and add them to Routines
 * <p>
 * The method in the class allows for the creation of multiple Workouts
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.3
 */

public class AddWorkoutActivity extends AppCompatActivity implements AddWorkoutPresenter.View {
    private AddWorkoutPresenter presenter;
    private EditText workoutNameField;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);
        this.presenter = new AddWorkoutPresenter(this, getIntent().getSerializableExtra("routine"));
    }

    /**
     * updates the title of the page
     *
     * @param title string title
     */
    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    /**
     * implements the buttons
     */
    @Override
    public void setupAddWorkoutButton() {
        Button addWorkoutBtn = findViewById(R.id.CreateWorkoutBtn2);
        workoutNameField = findViewById(R.id.WorkoutNameField);
        addWorkoutBtn.setOnClickListener(
                v -> presenter.addWorkoutTemplate(workoutNameField.getText().toString()));
    }

    /**
     * exits the page
     */
    @Override
    public void exitPage() {
        finish();
        startActivity(new Intent(this, StartWorkoutFromRoutinesActivity.class));
    }

    /**
     * Set an error for the workout name text field with a given error message
     *
     * @param message String error message to display for the workout name text
     */
    @Override
    public void setError(String message) {
        workoutNameField.setError(message);
        workoutNameField.requestFocus();
    }


}