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

/**
 * The class represents the activity for a WorkLog allowing users to see their work log
 *
 * The methods help display a page for a user to look at their log of workouts
 *
 * @author abdullah
 * @version 0.1
 * @layer 4
 */

public class WorkoutLogActivity extends AppCompatActivity implements WorkoutLogPresenter.View {
    private WorkoutLogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_log);
        this.presenter = new WorkoutLogPresenter(this);
    }

    /**
     * Updates the title of the page
     * @param title String representing the title
     */
    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    /**
     * displays workout logs on the page
     * @param logs a list of strings representing a workout
     */
    @Override
    public void displayLog(List<String> logs) {
        LinearLayout layout = findViewById(R.id.WorkoutLogsContainer);


        if (logs.size() == 0 ){
            TextView y = new TextView(this);
            y.setText("No workout logs found");
            y.setGravity(Gravity.CENTER);
            y.setPadding(0 , 20, 0, 0);
            layout.addView(y);
        }


        for (String log :  logs) {
            TextView t = new TextView(this);
            t.setText(log);
            t.setGravity(Gravity.CENTER);
            t.setPadding(0 , 20, 0, 0);
            layout.addView(t);
        }

    }


}