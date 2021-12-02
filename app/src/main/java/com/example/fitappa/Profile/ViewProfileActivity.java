package com.example.fitappa.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Authentication.OpensActivityWithProfile;
import com.example.fitappa.R;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class ViewProfileActivity extends AppCompatActivity implements Observer, OpensActivityWithProfile {
    private Profile myProfile;
    private Profile profile;
    private TextView followerNumber;
    private ProfileController profileController;
    private EditText searchText;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Profile");


        Intent retrieveIntent = getIntent();
        this.profile = (Profile) retrieveIntent.getSerializableExtra("persons_Profile");
        this.myProfile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");

        ProfilePresenter presenter = new ProfilePresenter(this, myProfile, profile);


        this.profileController = new ProfileController(this.myProfile);
        this.profileController.addObserver(this);

        TextView followButton = findViewById(R.id.followButton);
        followButton.setVisibility(View.INVISIBLE);

        if (!presenter.isMyProfile()) {
            followButton.setVisibility(View.VISIBLE);
        }

        TextView user = findViewById(R.id.userNameProfile);
        user.setText(presenter.getUsername());

        followerNumber = findViewById(R.id.followerNumber);
        followerNumber.setText(presenter.getFollow());

        TextView followingNumber = findViewById(R.id.followingNumber);
        followingNumber.setText(presenter.getFollowing());

        TextView submit = findViewById(R.id.submitSearch);
        searchText = findViewById(R.id.searchText);

        TextView settingsButton = findViewById(R.id.settingButton);


        submit.setOnClickListener(v -> presenter.searchForProfileWithUsername(searchText.getText().toString()));

        followButton.setOnClickListener(v -> followPress());
        settingsButton.setOnClickListener(v -> toSettings());

    }

    /**
     * Activated when Android back button is pressed. Return to current Profile view.
     */
    @Override
    public void onBackPressed() {
        backToCurrentProfilesViewProfile();
        super.onBackPressed();
    }

    /**
     * Open profile page to view for a profile that was searched for
     *
     * @param searchedProfile Profile that was searched for
     */
    @Override
    public void openActivityWith(Profile searchedProfile) {
        Intent intent = new Intent(this, ViewProfileActivity.class);
        intent.putExtra("my_Profile", this.myProfile);
        this.profile = searchedProfile;
        intent.putExtra("persons_Profile", this.profile);
        startActivity(intent);
    }

    /**
     * Display an error message given a message
     *
     * @param message String message to be displayed as error on call
     */
    @Override
    public void showErrorMessage(String message) {
        searchText.setError(message);
        searchText.requestFocus();
    }

    /**
     * When the user goes back from viewing a searched profile, update the view profile activity to show
     * current profile's information
     */
    private void backToCurrentProfilesViewProfile() {
        Intent home = new Intent(this, ViewProfileActivity.class);
        home.putExtra("my_Profile", this.myProfile);
        home.putExtra("persons_Profile", this.myProfile);
        startActivity(home);
    }

    /**
     * brings a user to their settings
     */
    private void toSettings() {
        Intent setting = new Intent(this, SettingsActivity.class);
        setting.putExtra("my_Profile", this.myProfile);
        startActivity(setting);
    }

    /**
     * Upon the follow button being pressed it sends this profile to profile controller
     */
    private void followPress() {
        profileController.setFollow(this.profile);
    }

    /**
     * An observer observable interaction viewing if the follow button is pressed and updating the follow count
     *
     * @param o   Observable would be ProfileController
     * @param arg would check for any updates
     */
    @Override
    public void update(Observable o, Object arg) {
        this.myProfile = this.profileController.getFollow1();
        this.profile = this.profileController.getFollow2();
        if (!myProfile.getUsername().equals(profile.getUsername())) {
            followerNumber.setText(profile.getFollowManager().followerCount());
        }
    }
}