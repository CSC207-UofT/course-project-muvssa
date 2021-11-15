package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.R;


public class AddWorkoutActivity extends AppCompatActivity {
    private Button addWorkoutBtn;
    private EditText workoutNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        // Initialize UI
        this.addWorkoutBtn = findViewById(R.id.CreateWorkoutBtn2);
        this.workoutNameField = findViewById(R.id.WorkoutNameField);

        this.addWorkoutBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                goBackToRoutine(workoutNameField.getText().toString());
            }
        });

    }

    public void goBackToRoutine(String workoutName) {
        Intent routine = new Intent(this, ViewRoutinesActivity.class);
        routine.putExtra("workoutName", workoutName);
        setResult(RESULT_OK, routine);
        finish();
    }

}