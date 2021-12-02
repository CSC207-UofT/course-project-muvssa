package com.example.fitappa.Routine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Profile.DashboardActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;

import java.util.List;
import java.util.Objects;

public class ViewRoutinesActivity extends AppCompatActivity implements ViewRoutinesPresenter.View {
    private ViewRoutinesPresenter presenter;
    private LinearLayout routinesLayout;
    private Profile profile;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default Android Stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routines);
        Objects.requireNonNull(getSupportActionBar()).setTitle("View Routines");

        // Load the elements
        routinesLayout = findViewById(R.id.routinesLayout);
        Button createRoutineBtn = findViewById(R.id.CreateRoutineBtn);

        // Get the profile
        this.profile = (Profile) getIntent().getSerializableExtra("my_Profile");

        // We must initialize the Presenter in the View.
        this.presenter = new ViewRoutinesPresenter(this, profile);

        // Initialize RoutinesView
        this.initializeRoutinesView(profile.getRoutines());

        // Listeners
        createRoutineBtn.setOnClickListener(view -> openAddRoutine());

    }

    /**
     * Activates when default Android back button is pressed. Takes user back to the
     * Dashboard Activity and passes a profile object as well
     */
    @Override
    public void onBackPressed() {
        backToDashboard();
        super.onBackPressed();
    }

    /**
     * This method updates the RoutineView with the given routine
     *
     * @param routine represents the given routine
     */
    @Override
    public void updateRoutinesView(Routine routine) {
        Button button = new Button(this);
        button.setText(routine.getName());

        button.setOnClickListener(view -> openViewRoutine(routine));

        routinesLayout.addView(button);
    }

    /**
     * This method opens the HomeActivity
     */
    private void backToDashboard() {
        Intent home = new Intent(this, DashboardActivity.class);
        home.putExtra("profile", profile);
        startActivity(home);
    }

    /**
     * This method initializes the RoutinesView with the given List of Routine
     *
     * @param routines represents List of Routine
     */
    private void initializeRoutinesView(List<Routine> routines) {
        for (Routine r : routines) {
            updateRoutinesView(r);
        }
    }


    /**
     * This method opens the AddRoutineActivity View
     */
    private void openAddRoutine() {
        Intent createRoutinesIntent = new Intent(this, AddRoutineActivity.class);
        startActivityForResult(createRoutinesIntent, 1);
    }

    /**
     * This method retrieves data from AddRoutineActivity view.
     *
     * @param requestCode represents the integer identification for the data
     * @param resultCode  represents the result of the retrieve
     * @param data        represents the data that is retrieved
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addRoutine(data.getStringExtra("routineName"));
        }
    }

    /**
     * This method opens the ViewRoutineActivity view
     *
     * @param routine represents the Routine to view
     */
    private void openViewRoutine(Routine routine) {
        Intent viewRoutine = new Intent(this, ViewRoutineActivity.class);
        viewRoutine.putExtra("routineObj", routine);
        viewRoutine.putExtra("profile", this.profile);
        startActivity(viewRoutine);
    }

}