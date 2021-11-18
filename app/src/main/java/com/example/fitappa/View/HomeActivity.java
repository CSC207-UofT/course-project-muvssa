package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button logoutBtn = findViewById(R.id.LogoutBtn);
        Button openRoutinesBtn = findViewById(R.id.GoToRoutinesBtn);
        Button openProfileBtn = findViewById(R.id.GoToProfilesBtn);
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        if (profile == null) {
            goBackToMain();
        }

        // Listeners
        openRoutinesBtn.setOnClickListener(v -> openRoutines());

        openProfileBtn.setOnClickListener(v -> openProfile());

        logoutBtn.setOnClickListener(v -> {
            profile.saveData();
            signOut();
            goBackToMain();
        });

    }

    /**
     * Sign out the current Firebase user
     */
    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    public void openRoutines() {
        Intent routines = new Intent(this, ViewRoutinesActivity.class);
        routines.putExtra("my_Profile", this.profile);
        startActivity(routines);
    }

    public void openProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("persons_Profile", profile);
        intent.putExtra("my_Profile", profile);
        startActivity(intent);
    }

    public void goBackToMain() {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}