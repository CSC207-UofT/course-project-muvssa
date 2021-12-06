package com.example.fitappa.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.fitappa.R;


public class WorkoutLogActivity extends AppCompatActivity {
    private WorkoutLogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_log);
    }
}