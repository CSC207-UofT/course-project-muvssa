package com.example.fitappa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fitappfiles.Profile;
import fitappfiles.Profiles;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class InteractorProfile extends AppCompatActivity implements Observer {
    private TextView user;
    private Profile myProfile;
    private Profile profile;
    private TextView followerNumber;
    private TextView followingNumber;
    private TextView submit;
    private TextView search;
    private TextView followButton;
    private TextView returnHome;
    private TextView goToWorkouts;
    private ModelProfile modelProfile;
    private Intent retrieveIntent;
    private Profiles profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_profile);
        this.retrieveIntent = getIntent();
        this.profile = (Profile) retrieveIntent.getSerializableExtra("persons_Profile");
        this.myProfile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");

        this.modelProfile = new ModelProfile(this.myProfile);
        this.modelProfile.addObserver(this);


        this.profiles = new Profiles();
        // for testing purposes, here we would have a database
        this.profiles.signUp("test","testpass", "testEmail");
        this.profiles.signUp(myProfile.getUser().getUsername(),"testpass", "testEmail");

        this.followButton = findViewById(R.id.followButton);
        this.followButton.setVisibility(View.INVISIBLE);

        this.returnHome = findViewById(R.id.returnHome);
        this.returnHome.setVisibility(View.INVISIBLE);
        if (!this.myProfile.getUser().getUsername().equals(this.profile.getUser().getUsername())){
            this.followButton.setVisibility(View.VISIBLE);
            this.returnHome.setVisibility(View.VISIBLE);
        }
        goToWorkouts = findViewById(R.id.gotToWorkouts);

        user = findViewById(R.id.userNameProfile);
        user.setText(profile.getUser().getUsername());

        followerNumber = findViewById(R.id.followerNumber);
        followerNumber.setText(profile.getProfileFollow().followerCount());

        followingNumber = findViewById(R.id.followingNumber);
        followingNumber.setText(profile.getProfileFollow().followingCount());

        submit =  findViewById(R.id.submitSearch);
        search =  findViewById(R.id.searchText);
        String name = this.myProfile.getUser().getUsername();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searched(search.getText().toString());
            }
        });

        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followPress();
            }
        });
        goToWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGoToWorkouts();
            }
        });

    }
    private void searched(String username) {
        Intent intent = new Intent(this, InteractorProfile.class);
        intent.putExtra("my_Profile", (Serializable) this.myProfile);
        this.profile = this.profiles.search(username);
        intent.putExtra("persons_Profile", (Serializable) this.profile);
        startActivity(intent);
    }
    private void home() {
        Intent intent = new Intent(this, InteractorProfile.class);
        intent.putExtra("my_Profile", (Serializable) this.myProfile);
        intent.putExtra("persons_Profile", (Serializable) this.myProfile);
        startActivity(intent);
    }
    private void followPress(){
        modelProfile.setFollow(this.profile);

    }
    private void setGoToWorkouts(){
        Intent intent = new Intent(this, WorkoutsActivity.class);
        intent.putExtra("my_Profile", (Serializable) this.myProfile);
        startActivity(intent);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.myProfile = this.modelProfile.getFollow1();
        this.profile = this.modelProfile.getFollow2();
        if (!myProfile.getUser().getUsername().equals(profile.getUser().getUsername())){
            followerNumber.setText(profile.getProfileFollow().followerCount());
        }
    }
}