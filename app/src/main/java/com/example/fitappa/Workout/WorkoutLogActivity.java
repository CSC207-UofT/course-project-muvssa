package com.example.fitappa.Workout;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;

import java.util.List;
import java.util.Objects;

/**
 * The class represents the activity for a WorkLog allowing users to see their work log
 * <p>
 * The methods help display a page for a user to look at their log of workouts
 *
 * @author abdullah
 * @version 0.1
 * @layer 4
 */

public class WorkoutLogActivity extends AppCompatActivity implements WorkoutLogPresenter.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_log);
        new WorkoutLogPresenter(this);
    }

    /**
     * Updates the title of the page
     *
     * @param title String representing the title
     */
    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    /**
     * displays workout logs on the page
     *
     * @param logs a list of strings representing a workout
     */
    @Override
    public void displayLog(List<String> logs) {
        LinearLayout layout = findViewById(R.id.WorkoutLogsContainer);


        if (logs.size() == 0) {
            TextView log1 = new TextView(this);

            String log1String = "No workout logs found";
            log1.setText(log1String);
            log1.setGravity(Gravity.CENTER);
            log1.setPadding(0, 20, 0, 0);
            layout.addView(log1);
        }


        for (String log : logs) {
            TextView log2 = new TextView(this);
            log2.setText(log);
            log2.setGravity(Gravity.CENTER);
            log2.setPadding(0, 20, 0, 0);
            layout.addView(log2);
        }

    }


}