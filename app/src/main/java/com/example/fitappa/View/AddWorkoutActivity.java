package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;


public class AddWorkoutActivity extends AppCompatActivity {
    private EditText workoutNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        // Initialize UI
        Button addWorkoutBtn = findViewById(R.id.CreateWorkoutBtn2);
        this.workoutNameField = findViewById(R.id.WorkoutNameField);

        addWorkoutBtn.setOnClickListener(v -> goBackToRoutine(workoutNameField.getText().toString()));

    }

    private void goBackToRoutine(String workoutName) {
        Intent routine = new Intent(this, ViewRoutinesActivity.class);
        routine.putExtra("workoutName", workoutName);
        setResult(RESULT_OK, routine);
        finish();
    }

}