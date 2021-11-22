package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;

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
        setContentView(R.layout.activity_home);

        Button logoutBtn = findViewById(R.id.LogoutBtn);
        Button openRoutinesBtn = findViewById(R.id.GoToRoutinesBtn);
        Button openProfileBtn = findViewById(R.id.GoToProfilesBtn);
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        checkAuth();

        // Listeners
        openRoutinesBtn.setOnClickListener(v -> openRoutines());
        openProfileBtn.setOnClickListener(v -> openProfile());

        logoutBtn.setOnClickListener(v -> signOut());

    }

    /**
     * This method opens the MainActivity view if the user is not logged in.
     */
    private void checkAuth() {
        if (this.profile == null) {
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
     * This method opens the ViewRoutinesActivity View
     */
    private void openRoutines() {
        Intent viewRoutines = new Intent(this, ViewRoutinesActivity.class);
        viewRoutines.putExtra("my_Profile", this.profile);
        startActivity(viewRoutines);
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
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}