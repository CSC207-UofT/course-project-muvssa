package com.example.fitappa.Workout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Exercise.AddExerciseActivity;
import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Exercise.Exercise.ExerciseRepository;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Routine.ViewRoutineActivity;

import java.io.Serializable;
import java.util.List;

public class ViewWorkoutActivity extends AppCompatActivity implements ViewWorkoutPresenter.View, ExerciseRepository.View {
    private ViewWorkoutPresenter presenter;
    private LinearLayout exerciseLayout;
    private WorkoutTemplate workoutTemplate;
    private Routine routine;
    private Profile profile;
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
        getSupportActionBar().setTitle("View Workout");


        Button addExerciseBtn = findViewById(R.id.AddExerciseBtn);
        Button back = findViewById(R.id.backButton3);
        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        TextView workoutLabel = findViewById(R.id.WorkoutLabel);
        this.workoutTemplate = (WorkoutTemplate) getIntent().getSerializableExtra("workoutObj");
        this.routine = (Routine) getIntent().getSerializableExtra("routineObj");
        this.profile = (Profile) getIntent().getSerializableExtra("profile");
        this.presenter = new ViewWorkoutPresenter(this, workoutTemplate, routine);

        String t = "Exercises in " + workoutTemplate.getName();
        workoutLabel.setText(t);

        addExerciseBtn.setOnClickListener(view -> openAddExercise());
        back.setOnClickListener(view -> presenter.updateWorkoutRoutine());

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
    public void goBackToViewRoutine() {
        Intent viewRoutine = new Intent(this, ViewRoutineActivity.class);
        viewRoutine.putExtra("routineObj", this.routine);
        viewRoutine.putExtra("profile", this.profile);
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