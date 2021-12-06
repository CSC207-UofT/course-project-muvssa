package com.example.fitappa.Workout.CRUD;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Exercise.AddExerciseActivity;
import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Exercise.Exercise.ExerciseRepository;
import com.example.fitappa.R;
import com.example.fitappa.Workout.StartWorkoutActivity;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * This class is a view class meant to open the activity_view_workout xml, a place for the user to view their Workouts
 *
 * The method in the class allow the user to go and view other Workouts or create more
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.3
 */

public class ViewWorkoutActivity extends AppCompatActivity implements ViewWorkoutPresenter.View, ExerciseRepository.View {
    private ViewWorkoutPresenter presenter;
    private LinearLayout exerciseLayout;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        this.presenter = new ViewWorkoutPresenter(this,
                getIntent().getSerializableExtra("workoutName"),
                getIntent().getSerializableExtra("routineName"));
    }

    /**
     * Activates when the android back button is pressed. Update the routine and call
     * goBackToViewRoutine().
     */
    @Override
    public void onBackPressed() {
        goBack();
    }

    /**
     * Executes after onCreate() completes and retrieves the exercises from the repository in order
     * to be displayed if the user goes to the AddExerciseActivity
     */
    @Override
    protected void onStart() {
        // TODO: refactor this to go on oncreate (then use presenter)
        super.onStart();
        // Get the exercises from repository and fill the exercises field
        ExerciseRepository exerciseRepository = new ExerciseRepository(this);
        exerciseRepository.retrieveExercises();
    }

    /**
     * This method opens the AddExerciseActivity view.
     */
    private void openAddExercise(List<ExerciseTemplate> exerciseTemplates) {
        Intent addExercise = new Intent(this, AddExerciseActivity.class);
        addExercise.putExtra("exercises", (Serializable) exerciseTemplates);
        startActivityForResult(addExercise, 1);
    }

    /**
     * This method opens the ViewRoutineActivity view.
     */
    @Override
    public void goBack() {
        startActivity(new Intent(this, StartWorkoutActivity.class));
    }

    @Override
    public void setupExerciseBtn() {

    }

    /**
     * This method retrieves data from AddExerciseActivity view.
     *
     * @param requestCode represents the integer identification for the data
     * @param resultCode  represents the result of the retrieve
     * @param data        represents the data that is retrieved
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addExercise((ExerciseTemplate) data.getSerializableExtra("exercise"));
        }
    }

    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    /**
     * This method updates ExerciseLayout with the given Exercise
     *
     * @param exerciseTemplate represents the given Exercise
     */
    @Override
    public void updateExerciseLayout(ExerciseTemplate exerciseTemplate) {
        Button button = new Button(this);
        button.setText(exerciseTemplate.getName());
        exerciseLayout.addView(button);
    }

    @Override
    public void setTitle(String name) {
        TextView workoutLabel = findViewById(R.id.WorkoutLabel);
        String t = name;
        workoutLabel.setText(t);
    }

    @Override
    public void loadExercise(List<ExerciseTemplate> exerciseTemplates) {
        // Set on click listener
        this.presenter.setExercises(exerciseTemplates);
        Button addExerciseBtn = findViewById(R.id.AddExerciseBtn);
        addExerciseBtn.setOnClickListener(view -> openAddExercise(exerciseTemplates));
    }
}