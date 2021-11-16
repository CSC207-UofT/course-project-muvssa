package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;

public class AddRoutineActivity extends AppCompatActivity {
    Button submitBtn;
    EditText routineName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        // Initialize elements
        this.submitBtn = findViewById(R.id.SaveRoutineBtn);
        this.routineName = findViewById(R.id.RoutineNameField);


        submitBtn.setOnClickListener(v -> goBackToWorkouts(routineName.getText().toString()));
    }


    public void goBackToWorkouts(String routineName) {
        Intent workout = new Intent(this, ViewRoutinesActivity.class);
        workout.putExtra("routineName", routineName);
        setResult(RESULT_OK, workout);
        finish();

    }

}