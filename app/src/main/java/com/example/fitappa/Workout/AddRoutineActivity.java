package com.example.fitappa.Workout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;

import java.util.Objects;

public class AddRoutineActivity extends AppCompatActivity {
    private EditText routineName;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add Routine");

        // Initialize elements
        Button submitBtn = findViewById(R.id.SaveRoutineBtn);
        this.routineName = findViewById(R.id.RoutineNameField);
        submitBtn.setOnClickListener(v -> goBack(routineName.getText().toString()));
    }

    /**
     * This method opens the ViewRoutinesActivity View and passes back the
     * name of the routine, routineName to it.
     *
     * @param routineName the name of the routine that was created
     */
    private void goBack(String routineName) {
        Intent viewRoutines = new Intent(this, StartWorkoutActivity.class);
        viewRoutines.putExtra("routineName", routineName);
        setResult(RESULT_OK, viewRoutines);
        finish();
    }

}