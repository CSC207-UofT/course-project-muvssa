package com.example.fitappa.View;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewRoutinePresenter;
import com.example.fitappa.R;

import java.util.ArrayList;

public class ViewRoutineActivity extends AppCompatActivity implements ViewRoutinePresenter.View {
    private Routine routine;
    private LinearLayout routineLayout;
    private Button addWorkoutBtn;
    private ViewRoutinePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routine);

        // Retrieve UI
        this.routineLayout = findViewById(R.id.RoutineLayout);
        this.addWorkoutBtn = findViewById(R.id.AddWorkoutBtn);

        // retrieve routine
        this.routine = (Routine) getIntent().getSerializableExtra("routineObj");

        // Setup presenter
        this.presenter = new ViewRoutinePresenter(this, this.routine);


        // Initialize view
        initializeRoutineView(this.routine.getWorkouts());

        // Listeners
        addWorkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openAddWorkout();
            }
        });


    }

    public void updateRoutineView(Workout workout) {
        Button button = new Button(this);
        button.setText(workout.getName());
        Log.d("WORKOUT NAME", workout.getName());
        routineLayout.addView(button);

    }

    public void initializeRoutineView(ArrayList<Workout> workouts) {
        for(Workout w : workouts) {
            updateRoutineView(w);
        }
    }

    private void openAddWorkout() {
        Intent createWorkoutIntent = new Intent(this, AddWorkoutActivity.class);
        startActivityForResult(createWorkoutIntent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            presenter.addWorkout(data.getStringExtra("workoutName").toString());
        }
    }


}