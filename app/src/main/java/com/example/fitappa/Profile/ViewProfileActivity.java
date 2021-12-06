package com.example.fitappa.Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;

import java.util.Objects;

/**
 * This class is a view class meant to open the activity_profiles xml, representing a GUI of the users profile
 *
 * The method in the class allow a user to interact with their profile, such as following, changing settings,
 * searching, etc
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @author Uthman
 * @author Abdullah
 *
 * @since 2.2
 */

public class ViewProfileActivity extends AppCompatActivity implements ViewProfilePresenter.View {
    private ViewProfilePresenter presenter;


    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        this.presenter = new ViewProfilePresenter(this);
    }

    /**
     * Activated when Android back button is pressed. Return to current Profile view if on
     * another profile, or back to dashboard is showing current profile
     */
    @Override
    public void onBackPressed() {
        backToDashboard();
    }

    /**
     * Go back to dashboard activity with the current profile
     */
    private void backToDashboard() {
        Intent dashboard = new Intent(this, DashboardActivity.class);
        startActivity(dashboard);
    }


    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
}