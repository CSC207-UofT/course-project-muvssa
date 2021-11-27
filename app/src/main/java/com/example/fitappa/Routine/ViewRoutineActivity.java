package com.example.fitappa.Routine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;
import com.example.fitappa.Workout.AddWorkoutActivity;
import com.example.fitappa.Workout.ViewWorkoutActivity;
import com.example.fitappa.Workout.Workout;

import java.util.List;
import java.util.Objects;

public class ViewRoutineActivity extends AppCompatActivity implements ViewRoutinePresenter.View {
    private LinearLayout routineLayout;
    private ViewRoutinePresenter presenter;
    private Profile profile;
    private Routine routine;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routine);
        Objects.requireNonNull(getSupportActionBar()).setTitle("View Routine");

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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * This method updates RoutineView by adding a Workout
     *
     * @param workout represents the Workout that must be added to RoutinesView
     */
    @Override
    public void updateRoutineView(Workout workout) {
        Button button = new Button(this);
        button.setText(workout.getName());
        button.setOnClickListener(view -> openViewWorkout(workout));
        routineLayout.addView(button);

    }

    /**
     * This method opens ViewRoutines Activity
     */
    public void goBackToViewRoutines() {
        Intent viewRoutines = new Intent(this, ViewRoutinesActivity.class);
        viewRoutines.putExtra("my_Profile", this.profile);
        startActivity(viewRoutines);
    }

    /**
     * This method initializes the RoutineView with the user's workouts.
     *
     * @param workouts represents the user's workouts
     */
    private void initializeRoutineView(List<Workout> workouts) {
        for (Workout w : workouts) {
            updateRoutineView(w);
        }
    }

    /**
     * Opens the AddWorkoutActivity view
     */
    private void openAddWorkout() {
        Intent addWorkout = new Intent(this, AddWorkoutActivity.class);
        startActivityForResult(addWorkout, 1);
    }

    /**
     * This method retrieves data from AddWorkoutActivity view.
     *
     * @param requestCode represents the integer identification for the data
     * @param resultCode  represents the result of the retrieve
     * @param data        represents the data that is retrieved
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addWorkout(data.getStringExtra("workoutName"));
        }
    }

    /**
     * This method opens the ViewWorkoutActivity view
     *
     * @param workout represents the Workout to open
     */
    private void openViewWorkout(Workout workout) {
        Intent viewWorkout = new Intent(this, ViewWorkoutActivity.class);
        viewWorkout.putExtra("routineObj", this.routine);
        viewWorkout.putExtra("workoutObj", workout);
        viewWorkout.putExtra("profile", this.profile);
        startActivity(viewWorkout);
    }
}