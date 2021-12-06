package com.example.fitappa.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.fitappa.R;

import java.util.Objects;


public class WorkoutLogActivity extends AppCompatActivity implements WorkoutLogPresenter.View {
    private WorkoutLogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_log);
    }

    @Override
    public void init() {

    }

    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

}