package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewRoutinePresenter;
import com.example.fitappa.R;

import java.util.List;

public class ViewRoutineActivity extends AppCompatActivity implements ViewRoutinePresenter.View {
    private LinearLayout routineLayout;
    private ViewRoutinePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routine);

        // Retrieve UI
        this.routineLayout = findViewById(R.id.RoutineLayout);
        Button addWorkoutBtn = findViewById(R.id.AddWorkoutBtn);

        // retrieve routine
        Routine routine = (Routine) getIntent().getSerializableExtra("routineObj");

        // Setup presenter
        this.presenter = new ViewRoutinePresenter(this, routine);


        // Initialize view
        initializeRoutineView(routine.getWorkouts());

        // Listeners
        addWorkoutBtn.setOnClickListener(view -> openAddWorkout());

    }

    @Override
    public void updateRoutineView(Workout workout) {
        Button button = new Button(this);
        button.setText(workout.getName());
        button.setOnClickListener(view -> openViewWorkout(workout));
        routineLayout.addView(button);

    }

    private void initializeRoutineView(List<Workout> workouts) {
        for (Workout w : workouts) {
            updateRoutineView(w);
        }
    }

    private void openAddWorkout() {
        Intent createWorkoutIntent = new Intent(this, AddWorkoutActivity.class);
        startActivityForResult(createWorkoutIntent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addWorkout(data.getStringExtra("workoutName"));
        }
    }

    private void openViewWorkout(Workout w) {
        Intent workout = new Intent(this, ViewWorkoutActivity.class);
        workout.putExtra("workoutObj", w);
        startActivity(workout);
    }
}