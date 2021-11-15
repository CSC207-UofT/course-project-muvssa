package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewRoutinesPresenter;
import com.example.fitappa.R;
import com.example.fitappa.Model.UseCase.Profile;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewRoutinesActivity extends AppCompatActivity implements ViewRoutinesPresenter.View {
    private Profile profile;
    private ViewRoutinesPresenter presenter;
    private LinearLayout routinesLayout;
    private Button createWorkoutBtn;
    private Button createRoutineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default Android Stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);

        // Load the elements
        routinesLayout = (LinearLayout) findViewById(R.id.routinesLayout);
        createWorkoutBtn = (Button) findViewById(R.id.CreateWorkoutBtn);
        createRoutineBtn = (Button) findViewById(R.id.CreateRoutineBtn);

        // Get the profile
        this.profile = (Profile) getIntent().getSerializableExtra("my_Profile");

        // We must initialize the Presenter in the View.
        this.presenter = new ViewRoutinesPresenter(this, profile);

        // Initialize RoutinesView
        this.initializeRoutinesView(this.profile.getRoutines());

        // Listeners
        createRoutineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddRoutine();
            }
        });

        createWorkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddWorkout();
            }
        });




    }


    @Override
    public void updateRoutinesView(Routine routine) {


        Button button = new Button(this);
        //button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText(routine.getName());
        //button.setBackgroundColor(Color.parseColor("#22359D"));
        //button.setTextColor(Color.parseColor("#ffffff"));

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openViewRoutine(routine);
            }
        });

        routinesLayout.addView(button);

    }

    public void initializeRoutinesView(ArrayList<Routine> routines) {
        for(Routine r : routines) {
            updateRoutinesView(r);
        }
    }

    private void openAddRoutine() {
        Intent createRoutinesIntent = new Intent(this, AddRoutineActivity.class);
        startActivityForResult(createRoutinesIntent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            presenter.addRoutine(data.getStringExtra("routineName").toString());
        }
    }

    private void openAddWorkout() {
        Intent createWorkoutIntent = new Intent(this, AddWorkoutActivity.class);
        startActivity(createWorkoutIntent);
    }

    public void openViewRoutine(Routine r) {
        Intent routine = new Intent(this, ViewRoutineActivity.class );
        routine.putExtra("routineObj", (Serializable) r);
        startActivity(routine);
    }

}