package com.example.fitappa.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Profile.DashboardActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements OpensActivityWithProfile {
    private EditText passwordField;
    private EditText emailField;
    private LoginPresenter presenter;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        presenter = new LoginPresenter(this);

        passwordField = findViewById(R.id.PasswordField);
        emailField = findViewById(R.id.EmailField);
        TextView loginBtn = findViewById(R.id.LogInBtn);

        loginBtn.setOnClickListener(v -> presenter.runLogin(emailField, passwordField));
    }

    /**
     * This method opens the DashboardActivity while passing in the profile.
     *
     * @param profile represents the Profile of the authenticated user
     */
    @Override
    public void openActivityWith(Profile profile) {
        Intent home = new Intent(this, DashboardActivity.class);
        home.putExtra("profile", profile);
        startActivity(home);
    }
}