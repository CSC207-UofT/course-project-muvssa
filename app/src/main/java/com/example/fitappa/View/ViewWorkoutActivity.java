package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewWorkoutPresenter;
import com.example.fitappa.R;

import java.io.Serializable;

public class ViewWorkoutActivity extends AppCompatActivity implements ViewWorkoutPresenter.View {
    private ViewWorkoutPresenter presenter;
    private Button addExerciseBtn;
    private LinearLayout exerciseLayout;
    private TextView workoutLabel;
    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);

        this.addExerciseBtn = findViewById(R.id.AddExerciseBtn);
        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        this.workoutLabel = findViewById(R.id.WorkoutLabel);
        this.workout = (Workout) getIntent().getSerializableExtra("workoutObj");
        this.presenter = new ViewWorkoutPresenter(this, workout);

        String t = "Exercises in " + workout.getName();
        this.workoutLabel.setText(t);

        addExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openAddExercise();
            }
        });


    }

    private void openAddExercise() {
        Intent addExerciseIntent = new Intent(this, AddExerciseActivity.class);
        addExerciseIntent.putExtra("workoutObj", (Serializable) this.workout);
        startActivityForResult(addExerciseIntent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            presenter.addExercise(data.getStringExtra("exerciseName").toString());
        }
    }


    @Override
    public void updateExerciseLayout(Exercise e) {
        Button button = new Button(this);
        button.setText(e.getName());
        exerciseLayout.addView(button);
    }
}