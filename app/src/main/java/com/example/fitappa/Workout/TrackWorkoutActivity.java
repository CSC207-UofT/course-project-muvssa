package com.example.fitappa.Workout;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;

import java.util.Objects;

/**
 * This class is a view class meant to open the activity_track_workout xml
 *
 * The method in the class contain data from the most recent OnSaveInstanceState
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 *
 * @since 0.1
 */

public class TrackWorkoutActivity extends AppCompatActivity {

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_workout);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Start Workout");
    }
}