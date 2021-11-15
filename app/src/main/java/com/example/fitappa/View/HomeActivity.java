package com.example.fitappa.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Presenter.ProfilePresenter;
import com.example.fitappa.R;

import java.io.Serializable;


public class HomeActivity extends AppCompatActivity {
    private Button logoutBtn;
    private Button openRoutinesBtn;
    private Button openProfileBtn;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.logoutBtn = findViewById(R.id.LogoutBtn);
        this.openRoutinesBtn = findViewById(R.id.GoToRoutinesBtn);
        this.openProfileBtn = findViewById(R.id.GoToProfilesBtn);
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        if(profile == null) {
            goBackToLogin();
        }

        // Listeners
        openRoutinesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutines();
            }
        });

        openProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                presenter.saveData();
//                profile = null;
//            }
//        });

    }

    public void openRoutines() {
        Intent routines = new Intent(this, ViewRoutinesActivity.class);
        routines.putExtra("my_Profile", (Serializable) this.profile);
        startActivity(routines);
    }

    public void openProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("persons_Profile", profile);
        intent.putExtra("my_Profile", profile);
        startActivity(intent);
    }

    public void goBackToLogin() {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

}