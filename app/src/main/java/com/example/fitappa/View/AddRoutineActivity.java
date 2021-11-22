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

    /**
     * This method is called when the activity starts.
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        // Initialize elements
        this.submitBtn = findViewById(R.id.SaveRoutineBtn);
        this.routineName = findViewById(R.id.RoutineNameField);


        submitBtn.setOnClickListener(v -> goBackToWorkouts(routineName.getText().toString()));
    }

    /**
     * This method opens the ViewRoutinesActivity View and passes back the
     * name of the routine, routineName to it.
     * @param routineName the name of the routine that was created
     */
    private void goBackToWorkouts(String routineName) {
        Intent viewRoutines = new Intent(this, ViewRoutinesActivity.class);
        viewRoutines.putExtra("routineName", routineName);
        setResult(RESULT_OK, viewRoutines);
        finish();
    }

}