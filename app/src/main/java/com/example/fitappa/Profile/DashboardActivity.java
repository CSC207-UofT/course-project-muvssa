package com.example.fitappa.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Authentication.MainActivity;
import com.example.fitappa.R;
import com.example.fitappa.Workout.StartWorkoutActivity;
import com.example.fitappa.Workout.WorkoutLogActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

/**
 * This class is a view class meant to open the activity_dashboard xml, a hub between other pages in the app
 *
 * The method in the class allow the user to go to ViewProfileActivity, MainActivity, or StartWorkoutActivity
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author
 * @since 0.6
 */

public class DashboardActivity extends AppCompatActivity implements DashboardPresenter.View {
    private DashboardPresenter presenter;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.presenter = new DashboardPresenter(this, getIntent().getSerializableExtra("profile"));
    }

    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    public void setupLogoutBtn(Profile profile) {
        Button logoutBtn = findViewById(R.id.LogoutBtn);
        logoutBtn.setOnClickListener(v -> signOut());
    }

    @Override
    public void setupWorkoutBtn(Profile profile) {
        Button startWorkoutBtn = findViewById(R.id.startWorkoutNav);
        startWorkoutBtn.setOnClickListener(v -> openStartWorkout(profile));
    }

    @Override
    public void setupProfileBtn(Profile profile) {
        Button openProfileBtn = findViewById(R.id.goToProfilesBtn);
        openProfileBtn.setOnClickListener(v -> openProfile(profile));
    }

    @Override
    public void setupLogBtn() {
        Button btn = findViewById(R.id.WorkoutLogsBtn);
        btn.setOnClickListener(v -> openLogs());
    }

    private void openLogs() {
        startActivity(new Intent(this, WorkoutLogActivity.class));
    }

    /**
     * Sign out the current Firebase user
     */
    private void signOut() {
        // Remote
        FirebaseAuth.getInstance().signOut();

        goBackToMain();
    }

    /**
     * This method opens the ProfileActivity View
     */
    private void openProfile(Profile profile) {
        Intent profile1 = new Intent(this, ViewProfileActivity.class);
        profile1.putExtra("persons_Profile", profile);
        profile1.putExtra("my_Profile", profile);
        startActivity(profile1);
    }

    /**
     * This method opens the MainActivity View
     */
    private void goBackToMain() {
        finish();
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    /**
     * This method opens the StartWorkout view
     */
    private void openStartWorkout(Profile profile) {
        Intent startWorkout = new Intent(this, StartWorkoutActivity.class);
        startWorkout.putExtra("profile", profile);
        startActivity(startWorkout);
    }

    /**
     * This method overrides the functionality of the android back button and does nothing so that the user
     * cannot go back to the MainActivity or login/signup activities. The only way they can return is through
     * the logout button.
     */
    @Override
    public void onBackPressed() {
        // Do nothing so you cannot go back from this activity
    }
}