package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Entity.Exercise;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewWorkoutPresenter;
import com.example.fitappa.R;

public class ViewWorkoutActivity extends AppCompatActivity implements ViewWorkoutPresenter.View {
    private ViewWorkoutPresenter presenter;
    private LinearLayout exerciseLayout;
    private Workout workout;
    private Routine routine;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);

        Button addExerciseBtn = findViewById(R.id.AddExerciseBtn);
        Button back = findViewById(R.id.backButton3);
        this.exerciseLayout = findViewById(R.id.ExerciseLayout);
        TextView workoutLabel = findViewById(R.id.WorkoutLabel);
        this.workout = (Workout) getIntent().getSerializableExtra("workoutObj");
        this.routine = (Routine) getIntent().getSerializableExtra("routineObj");
        this.profile = (Profile) getIntent().getSerializableExtra("profile");
        this.presenter = new ViewWorkoutPresenter(this, workout, routine);

        String t = "Exercises in " + workout.getName();
        workoutLabel.setText(t);

        addExerciseBtn.setOnClickListener(view -> openAddExercise());
        back.setOnClickListener(view -> presenter.updateWorkoutRoutine());


    }

    private void openAddExercise() {
        Intent addExerciseIntent = new Intent(this, AddExerciseActivity.class);
        addExerciseIntent.putExtra("workoutObj", this.workout);
        startActivityForResult(addExerciseIntent, 1);
    }
    public void back() {
        Intent intent = new Intent(this, ViewRoutineActivity.class);
        intent.putExtra("routineObj", this.routine);
        intent.putExtra("profile", this.profile);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addExercise(data.getStringExtra("exerciseName"));
        }
    }


    @Override
    public void updateExerciseLayout(Exercise e) {
        Button button = new Button(this);
        button.setText(e.getName());
        exerciseLayout.addView(button);
    }
}