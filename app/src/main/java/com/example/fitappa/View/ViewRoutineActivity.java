package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewRoutinePresenter;
import com.example.fitappa.R;

import java.util.List;

public class ViewRoutineActivity extends AppCompatActivity implements ViewRoutinePresenter.View {
    private LinearLayout routineLayout;
    private ViewRoutinePresenter presenter;
    private Profile profile;
    private Routine routine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routine);

        // Retrieve UI
        this.routineLayout = findViewById(R.id.RoutineLayout);
        Button addWorkoutBtn = findViewById(R.id.AddWorkoutBtn);
        Button back = findViewById(R.id.backButton2);

        // retrieve routine
        this.routine = (Routine) getIntent().getSerializableExtra("routineObj");

        // retrieve profile
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        // Setup presenter
        this.presenter = new ViewRoutinePresenter(this, routine, profile);


        // Initialize view
        initializeRoutineView(routine.getWorkouts());

        // Listeners
        addWorkoutBtn.setOnClickListener(view -> openAddWorkout());

        back.setOnClickListener(view -> presenter.updateProfileRoutine());

    }

    @Override
    public void updateRoutineView(Workout workout) {
        Button button = new Button(this);
        button.setText(workout.getName());
        button.setOnClickListener(view -> openViewWorkout(workout));
        routineLayout.addView(button);

    }
    public void back() {
        Intent intent = new Intent(this, ViewRoutinesActivity.class);
        // put routine into the profile send back the profile
        intent.putExtra("my_Profile", this.profile);
        startActivity(intent);
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
        workout.putExtra("routineObj", this.routine);
        workout.putExtra("workoutObj", w);
        workout.putExtra("profile", this.profile);
        startActivity(workout);
    }
}