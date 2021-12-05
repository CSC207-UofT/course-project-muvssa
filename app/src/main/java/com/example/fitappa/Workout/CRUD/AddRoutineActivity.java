package com.example.fitappa.Workout.CRUD;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;
import com.example.fitappa.Workout.StartWorkoutActivity;

import java.util.Objects;

/**
 * This class is a view class meant to open the activity_add_routine xml, allowing users to interact with a Routine
 * which is a list of workouts
 *
 * The method in the class allow users to interact and create routines
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.4
 */

public class AddRoutineActivity extends AppCompatActivity implements AddRoutinePresenter.View {
    private AddRoutinePresenter presenter;
    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        this.presenter = new AddRoutinePresenter(this);

        // Initialize elements
    }

    /**
     * This method opens the ViewRoutinesActivity View
     *
     */
    public void exitPage() {
        startActivity(new Intent(this, StartWorkoutActivity.class));
    }

    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    public void setupAddRoutineButton() {
        Button submitBtn = findViewById(R.id.SaveRoutineBtn);
        EditText routineName = findViewById(R.id.RoutineNameField);
        submitBtn.setOnClickListener(v -> presenter.addRoutine(routineName.getText().toString()));
    }
}