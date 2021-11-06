package com.example.fitappa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import core.useCase.Profile;

import java.util.Observable;
import java.util.Observer;

public class InteractorProfile extends AppCompatActivity implements Observer {
    private TextView user;
    private TextView b;
    private Profile profile;
    private ModelProfile modelProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_profile);

        System.out.println("heleleoeoeoeoeoeo");

        modelProfile = new ModelProfile();
        modelProfile.addObserver(this);
        user = findViewById(R.id.userName);
        b = findViewById(R.id.back);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenu();
            }
        });

    }

    private void mainMenu() {

        Intent intent = new Intent(this, Interactor.class);
        startActivity(intent);
    }


    @Override
    public void update(Observable o, Object arg) {
        this.profile = modelProfile.getProfile();
        user.setText(profile.getUser().getUsername());
    }
}