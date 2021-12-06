package com.example.fitappa.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fitappa.R;

import java.util.List;
import java.util.Objects;


public class WorkoutLogActivity extends AppCompatActivity implements WorkoutLogPresenter.View {
    private WorkoutLogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_log);
        this.presenter = new WorkoutLogPresenter(this);
    }

    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    public void displayLog(List<String> logs) {
        LinearLayout layout = findViewById(R.id.WorkoutLogsContainer);


        if (logs.size() == 0 ){
            TextView y = new TextView(this);
            y.setText("No workout logs found");
            y.setGravity(Gravity.CENTER);
            layout.addView(y);
        }


        for (String log :  logs) {
            TextView t = new TextView(this);
            t.setText(log);
            t.setGravity(Gravity.CENTER);
            layout.addView(t);
        }

    }


}