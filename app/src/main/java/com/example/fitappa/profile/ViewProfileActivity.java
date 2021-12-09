package com.example.fitappa.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;
import com.example.fitappa.authentication.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

/**
 * This class is a view class meant to open the activity_profiles xml, representing a GUI of the users profile
 * <p>
 * The method in the class allow a user to interact with their profile, such as following, changing settings,
 * searching, etc
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @author Uthman
 * @author Abdullah
 * @since 2.2
 */

public class ViewProfileActivity extends AppCompatActivity implements ViewProfilePresenter.View {
    private ViewProfilePresenter presenter;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText weightField;
    private EditText heightField;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);
        this.presenter = new ViewProfilePresenter(this);
    }

    /**
     * Activated when Android back button is pressed. Return to current profile view if on
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
        finish();
        Intent dashboard = new Intent(this, DashboardActivity.class);
        startActivity(dashboard);
    }


    @Override
    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    public void setupElements() {
        Button saveBtn = findViewById(R.id.saveSettingsBtn);
        saveBtn.setOnClickListener(v -> this.saveSettings());

        Button logoutBtn = findViewById(R.id.LogoutButton);
        logoutBtn.setOnClickListener(v -> presenter.logout());

        this.firstNameField = findViewById(R.id.f_name_field);
        this.lastNameField = findViewById(R.id.l_name_field);
        this.weightField = findViewById(R.id.WeightField);
        this.heightField = findViewById(R.id.HeightField);
    }

    private void saveSettings() {
        presenter.saveSettings(firstNameField.getText().toString(),
                lastNameField.getText().toString(),
                weightField.getText().toString(),
                heightField.getText().toString());
    }


    @Override
    public void setup(String username, String firstName, String lastName, String weight, String height) {
        TextView usernameText = findViewById(R.id.userNameProfile);
        usernameText.setText(username);

        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        weightField.setText(weight);
        heightField.setText(height);

    }

    @Override
    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, MainActivity.class));
    }

}