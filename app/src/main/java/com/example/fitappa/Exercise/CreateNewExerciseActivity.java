package com.example.fitappa.Exercise;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;

import java.util.Objects;

/**
 * This Activity is activated when the user wants to create a new exercise to add to their default exercises list.
 * Once completed, it will return to AddExerciseActivity
 *
 * The method in gives the recently supplied onSaveInstanceState
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 *
 * @since 0.3
 */
public class CreateNewExerciseActivity extends AppCompatActivity {

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Create New Exercise");


//        EditText exerciseName = findViewById(R.id.exerciseName);
    }
}
