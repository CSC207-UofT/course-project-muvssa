package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.Presenter.ViewRoutinesPresenter;
import com.example.fitappa.R;

import java.util.List;

public class ViewRoutinesActivity extends AppCompatActivity implements ViewRoutinesPresenter.View {
    private ViewRoutinesPresenter presenter;
    private LinearLayout routinesLayout;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default Android Stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routines);

        // Load the elements
        routinesLayout = findViewById(R.id.routinesLayout);
        Button createRoutineBtn = findViewById(R.id.CreateRoutineBtn);
        Button back = findViewById(R.id.backButton);

        // Get the profile
        this.profile = (Profile) getIntent().getSerializableExtra("my_Profile");

        // We must initialize the Presenter in the View.
        this.presenter = new ViewRoutinesPresenter(this, profile);

        // Initialize RoutinesView
        this.initializeRoutinesView(profile.getRoutines());

        // Listeners
        createRoutineBtn.setOnClickListener(view -> openAddRoutine());
        back.setOnClickListener(view -> back());

    }


    @Override
    public void updateRoutinesView(Routine routine) {
        Button button = new Button(this);
        button.setText(routine.getName());

        button.setOnClickListener(view -> openViewRoutine(routine));

        routinesLayout.addView(button);

    }
    @Override
    public void back() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("profile", profile);
        startActivity(intent);
    }

    private void initializeRoutinesView(List<Routine> routines) {
        for (Routine r : routines) {
            updateRoutinesView(r);
        }
    }

    private void openAddRoutine() {
        Intent createRoutinesIntent = new Intent(this, AddRoutineActivity.class);
        startActivityForResult(createRoutinesIntent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addRoutine(data.getStringExtra("routineName"));
        }
    }

    private void openViewRoutine(Routine r) {
        Intent routine = new Intent(this, ViewRoutineActivity.class);
        routine.putExtra("routineObj", r);
        routine.putExtra("profile", this.profile);
        startActivity(routine);
    }

}