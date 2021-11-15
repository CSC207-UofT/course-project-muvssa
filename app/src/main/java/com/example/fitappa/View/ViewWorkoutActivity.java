package com.example.fitappa.View;

import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Presenter.ViewWorkoutPresenter;
import com.example.fitappa.R;

public class ViewWorkoutActivity extends AppCompatActivity {
    private ViewWorkoutPresenter presenter;
    private Button addExerciseBtn;
    private LinearLayout ExerciseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
    }
}