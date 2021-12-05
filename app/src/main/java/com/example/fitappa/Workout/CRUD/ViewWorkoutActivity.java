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
    private WorkoutTemplate workoutTemplate;
    private List<ExerciseTemplate> exerciseTemplates;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
        Objects.requireNonNull(getSupportActionBar()).setTitle("View Workout");


        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        this.workoutTemplate = (WorkoutTemplate) getIntent().getSerializableExtra(getString(R.string.WorkoutObject));
        this.presenter = new ViewWorkoutPresenter(this, workoutTemplate);


        // Set Title
        TextView workoutLabel = findViewById(R.id.WorkoutLabel);
        String t = "Exercises in " + workoutTemplate.getName();
        workoutLabel.setText(t);




        // Set on click listener
        Button addExerciseBtn = findViewById(R.id.AddExerciseBtn);
        addExerciseBtn.setOnClickListener(view -> openAddExercise());

    }

    /**
     * Activates when the android back button is pressed. Update the routine and call
     * goBackToViewRoutine().
     */
    @Override
    public void onBackPressed() {
        presenter.updateWorkoutRoutine();
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
    private void openAddExercise() {
        Intent addExercise = new Intent(this, AddExerciseActivity.class);
        addExercise.putExtra("workoutObj", this.workoutTemplate);
        addExercise.putExtra("exercises", (Serializable) this.exerciseTemplates);
        startActivityForResult(addExercise, 1);
    }

    /**
     * This method opens the ViewRoutineActivity view.
     */
    @Override
    public void goBack() {
        finish();
        Intent viewRoutine = new Intent(this, StartWorkoutActivity.class);
        startActivity(viewRoutine);
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

    /**
     * This method loads all the Workout's exercises and updates it in the
     * ExerciseLayout view component.
     *
     * @param exerciseTemplates represents the Exercise objects stored in the Workout
     */
    @Override
    public void loadExercise(List<ExerciseTemplate> exerciseTemplates) {
        this.exerciseTemplates = exerciseTemplates;
    }
}