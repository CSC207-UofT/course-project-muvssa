package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.R;

import java.io.Serializable;

public class AddRoutineActivity extends AppCompatActivity {
    Button submitBtn;
    EditText routineName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        // Initialize elements
        this.submitBtn = (Button) findViewById(R.id.SaveRoutineBtn);
        this.routineName = (EditText) findViewById(R.id.RoutineNameField);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToWorkouts(routineName.getText().toString());
            }
        });
    }


    public void goBackToWorkouts(String routineName)
    {
        Intent workout = new Intent(this, WorkoutsActivity.class);
        workout.putExtra("routineName", routineName);
        setResult(RESULT_OK, workout);
        finish();

    }

}