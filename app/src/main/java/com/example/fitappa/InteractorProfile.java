package com.example.fitappa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fitappfiles.Profile;
import fitappfiles.Profiles;

import java.io.Serializable;

public class InteractorProfile extends AppCompatActivity {
    private TextView user;
    private Profile profile;
    private TextView followerNumber;
    private TextView followingNumber;
    private TextView submit;
    private TextView search;
    private ModelProfile modelProfile;
    private Intent retrieveIntent;
    private Profiles profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_profile);
        this.retrieveIntent = getIntent();
        this.profile = (Profile) retrieveIntent.getSerializableExtra("persons_Profile");
        this.profiles = new Profiles();
        // for testing purposes, here we would have a database
        this.profiles.signUp("test","testpass", "testEmail");



        user = findViewById(R.id.userNameProfile);
        user.setText(profile.getUser().getUsername());

        followerNumber = findViewById(R.id.followerNumber);
        followerNumber.setText(profile.getProfileFollow().followerCount());

        followingNumber = findViewById(R.id.followingNumber);
        followingNumber.setText(profile.getProfileFollow().followingCount());

        submit =  findViewById(R.id.submitSearch);
        search =  findViewById(R.id.searchText);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searched(search.getText().toString());
            }
        });

    }
    private void searched(String username) {
        this.profile = this.profiles.search(username);

        Intent intent = new Intent(this, InteractorProfile.class);
        intent.putExtra("persons_Profile", (Serializable) this.profile);
        startActivity(intent);
    }

}