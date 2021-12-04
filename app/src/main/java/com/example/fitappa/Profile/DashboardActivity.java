package com.example.fitappa.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Authentication.MainActivity;
import com.example.fitappa.R;
import com.example.fitappa.Workout.StartWorkoutActivity;
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

public class DashboardActivity extends AppCompatActivity {
    private Profile profile;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Dashboard");


        Button logoutBtn = findViewById(R.id.LogoutBtn);
        Button openProfileBtn = findViewById(R.id.GoToProfilesBtn);
        Button startWorkoutBtn = findViewById(R.id.startWorkoutNav);
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        checkAuth();

        // Listeners
        openProfileBtn.setOnClickListener(v -> openProfile());
        startWorkoutBtn.setOnClickListener(v -> openStartWorkout());
        logoutBtn.setOnClickListener(v -> signOut());

    }

    /**
     * This method opens the MainActivity view if the user is not logged in.
     */
    private void checkAuth() {
        if (this.profile == null) {
            FirebaseAuth.getInstance().signOut();
            goBackToMain();
        }
    }

    /**
     * Sign out the current Firebase user
     */
    private void signOut() {
        // Remote
        FirebaseAuth.getInstance().signOut();

        // Local
        profile.saveData();
        goBackToMain();
    }

    /**
     * This method opens the ProfileActivity View
     */
    private void openProfile() {
        Intent profile = new Intent(this, ViewProfileActivity.class);
        profile.putExtra("persons_Profile", this.profile);
        profile.putExtra("my_Profile", this.profile);
        startActivity(profile);
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
    private void openStartWorkout() {
        Intent startWorkout = new Intent(this, StartWorkoutActivity.class);
        startWorkout.putExtra("profile", this.profile);
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