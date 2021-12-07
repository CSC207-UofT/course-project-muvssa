package com.example.fitappa.exercise.exercise_template;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;
import com.example.fitappa.workout.workout_template.ViewWorkoutActivity;

import java.util.List;
import java.util.Objects;

/**
 * This class is a view class meant to open the activity_add_exercise xml, a GUI which allows users to add
 * new exercises
 * <p>
 * The method in the class allow the user to interact and create new exercises
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.6
 */
public class AddExerciseActivity extends AppCompatActivity implements AddExercisePresenter.View {

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        // Initialize presenter
        new AddExercisePresenter(this, getIntent().getSerializableExtra("exercises"));
    }

    /**
     * This method displays all the exercises and updates it in the
     * ExerciseLayout view component.
     */
    @Override
    public void displayExercises(List<ExerciseTemplate> exerciseTemplates) {
        for (ExerciseTemplate exerciseTemplate : exerciseTemplates) {
            updateExerciseLayout(exerciseTemplate);
        }
    }

    /**
     * This method updates the ExerciseLayout view component on AddExerciseActivity
     * by adding the exercise to the layout.
     *
     * @param exerciseTemplate represents the exercise object to add to the ExerciseLayout
     */
    private void updateExerciseLayout(ExerciseTemplate exerciseTemplate) {
        Button button = new Button(this);
        button.setText(exerciseTemplate.getName());
        button.setOnClickListener(view -> addExerciseToWorkout(exerciseTemplate));

        LinearLayout exerciseLayout = findViewById(R.id.ExerciseLayout);
        exerciseLayout.addView(button);
    }

    /**
     * This method opens the ViewWorkoutActivity view and sends the selected exercise.
     *
     * @param exerciseTemplate represents the exercise to be returned to ViewWorkoutActivity
     */
    private void addExerciseToWorkout(ExerciseTemplate exerciseTemplate) {
        Intent viewWorkout = new Intent(this, ViewWorkoutActivity.class);
        viewWorkout.putExtra("exercise", exerciseTemplate);
        setResult(RESULT_OK, viewWorkout);
        finish();
    }

    /**
     * Sets the app bar title
     *
     * @param title title of the app bar
     */
    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);

    }
}