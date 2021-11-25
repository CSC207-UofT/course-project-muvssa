package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Presenter.ProfileController;
import com.example.fitappa.Presenter.ProfilePresenter;
import com.example.fitappa.R;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class ViewProfileActivity extends AppCompatActivity implements Observer, ProfilePresenter.View {
    private Profile myProfile;
    private Profile profile;
    private TextView followerNumber;
    private ProfileController profileController;

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

        TextView returnHome = findViewById(R.id.returnHome);
        returnHome.setVisibility(View.INVISIBLE);
        if (!presenter.isMyProfile()) {
            followButton.setVisibility(View.VISIBLE);
            returnHome.setVisibility(View.VISIBLE);
        }

        TextView user = findViewById(R.id.userNameProfile);
        user.setText(presenter.getUsername());

        followerNumber = findViewById(R.id.followerNumber);
        followerNumber.setText(presenter.getFollow());

        TextView followingNumber = findViewById(R.id.followingNumber);
        followingNumber.setText(presenter.getFollowing());

//        TextView submit = findViewById(R.id.submitSearch);
//        TextView search = findViewById(R.id.searchText);
//
//        submit.setOnClickListener(v -> presenter.searching(search.getText().toString()));

        returnHome.setOnClickListener(v -> home());
        followButton.setOnClickListener(v -> followPress());

    }

    // TODO: Whoever created this method, add the javadocs
    @Override
    public void searched(Profile searchedProfile) {
        Intent intent = new Intent(this, ViewProfileActivity.class);
        intent.putExtra("my_Profile", this.myProfile);
        this.profile = searchedProfile;
        intent.putExtra("persons_Profile", this.profile);
        startActivity(intent);
    }

    // TODO: Whoever created this method, add the javadocs
    @Override
    public void home() {
        Intent home = new Intent(this, ViewProfileActivity.class);
        home.putExtra("my_Profile", this.myProfile);
        home.putExtra("persons_Profile", this.myProfile);
        startActivity(home);
    }

    // TODO: Whoever created this method, add the javadocs
    private void followPress() {
        profileController.setFollow(this.profile);
    }

    // TODO: Whoever created this method, add the javadocs
    @Override
    public void update(Observable o, Object arg) {
        this.myProfile = this.profileController.getFollow1();
        this.profile = this.profileController.getFollow2();
        if (!myProfile.getUser().getUsername().equals(profile.getUser().getUsername())) {
            followerNumber.setText(profile.getFollowManager().getFollowerCount());
        }
    }
}