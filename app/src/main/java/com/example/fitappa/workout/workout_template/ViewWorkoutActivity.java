package com.example.fitappa.workout.workout_template;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;
import com.example.fitappa.exercise.exercise_template.AddExerciseActivity;
import com.example.fitappa.exercise.exercise_template.ExerciseRepository;
import com.example.fitappa.exercise.exercise_template.ExerciseTemplate;
import com.example.fitappa.routine.StartWorkoutFromRoutinesActivity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * This class is a view class meant to open the activity_view_workout xml, a place for the user to view their Workouts
 * <p>
 * The method in the class allow the user to go and view other Workouts or create more
 * <p>
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
        super.onStart();
        // Get the exercises from repository and fill the exercises field
        ExerciseRepository exerciseRepository = new ExerciseRepository(this);
        exerciseRepository.retrieveExercises();
    }

    /**
     * This method opens the AddExerciseActivity view.
     */
    @SuppressWarnings("deprecation")
    private void openAddExercise(List<ExerciseTemplate> exerciseTemplates) {
        Intent addExercise = new Intent(this, AddExerciseActivity.class);
        addExercise.putExtra("exercises", (Serializable) exerciseTemplates);
        startActivityForResult(addExercise, 1);
    }

    /**
     * This method opens the ViewRoutineActivity view.
     */
    private void goBack() {
        finish();
        startActivity(new Intent(this, StartWorkoutFromRoutinesActivity.class));
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
     * This method updates ExerciseLayout with the given exercise
     *
     * @param exerciseTemplate represents the given exercise
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
        workoutLabel.setText(name);
    }

    @Override
    public void loadExercise(List<ExerciseTemplate> exerciseTemplates) {
        // Set on click listener
        Button addExerciseBtn = findViewById(R.id.AddExerciseBtn);
        addExerciseBtn.setOnClickListener(view -> openAddExercise(exerciseTemplates));
    }
}