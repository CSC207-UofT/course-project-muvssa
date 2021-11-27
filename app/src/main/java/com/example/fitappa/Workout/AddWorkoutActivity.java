package com.example.fitappa.Workout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;
import com.example.fitappa.Routine.ViewRoutinesActivity;

import java.util.Objects;


public class AddWorkoutActivity extends AppCompatActivity {
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
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add Workout");

        // Initialize UI
        Button addWorkoutBtn = findViewById(R.id.CreateWorkoutBtn2);
        this.workoutNameField = findViewById(R.id.WorkoutNameField);

        addWorkoutBtn.setOnClickListener(v -> goBackToRoutine(workoutNameField.getText().toString()));

    }

    /**
     * This method opens the ViewRoutinesActivity and passes back
     * workoutName to it.
     *
     * @param workoutName the name of the workout that was created
     */
    private void goBackToRoutine(String workoutName) {
        Intent viewRoutines = new Intent(this, ViewRoutinesActivity.class);
        viewRoutines.putExtra("workoutName", workoutName);
        setResult(RESULT_OK, viewRoutines);
        finish();
    }

}