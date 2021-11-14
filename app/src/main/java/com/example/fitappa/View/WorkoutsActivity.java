package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.WorkoutsActivityPresenter;
import com.example.fitappa.R;
import com.example.fitappa.Model.UseCase.Profile;

import java.util.ArrayList;

public class WorkoutsActivity extends AppCompatActivity implements WorkoutsActivityPresenter.View {
    private Intent retrieveIntent;
    private Profile profile;
    private WorkoutsActivityPresenter presenter;
    private TableLayout routinesView;
    private Button createWorkoutBtn;
    private Button createRoutineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default Android Stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        this.retrieveIntent = getIntent();

        // Load the elements
        routinesView = (TableLayout) findViewById(R.id.routinesView);
        createWorkoutBtn = (Button) findViewById(R.id.CreateWorkoutBtn);
        createRoutineBtn = (Button) findViewById(R.id.CreateRoutineBtn);

        // Get the profile
        this.profile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");

        // We must initialize the Presenter in the View.
        this.presenter = new WorkoutsActivityPresenter(this, profile);

        // Test
        this.updateRoutinesView(profile.getRoutines());

        // Listeners
        createRoutineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }


    @Override
    public void updateRoutinesView(ArrayList<Routine> routines) {
        for(Routine routine : routines) {

            LinearLayout myLayout = findViewById(R.id.routinesLayout);

            Button button = new Button(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

            button.setText(routine.getName());


            TableRow row = new TableRow(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

            row.addView(button);

            routinesView.addView(row);
        }
    }

    private void openCreateRoutines() {
        Intent createRoutinesIntent = new Intent(this, SignUpActivity.class);
        startActivity(createRoutinesIntent);
    }

    private void openCreateWorkout() {
        Intent createWorkoutIntent = new Intent(this, CreateWorkoutActivity.class);
        startActivity(createWorkoutIntent);
    }

}