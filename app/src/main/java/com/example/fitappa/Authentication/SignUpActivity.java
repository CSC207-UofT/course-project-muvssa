package com.example.fitappa.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.Profile.SetupActivity;
import com.example.fitappa.R;

import java.util.Objects;

/**
 * This activity is activated when the user selects signup from the MainActivity and wants to sign up with a new account
 * <p>
 * The methods in this activity allow the user to input information into the program to sign up
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @since 2.1
 */
public class SignUpActivity extends AppCompatActivity implements OpensActivityWithProfile {
    private SignUpPresenter presenter;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Objects.requireNonNull(getSupportActionBar()).hide();

        presenter = new SignUpPresenter(this);

        setupButtons();

    }

    /**
     * Setup the buttons for this activity
     */
    private void setupButtons() {
        EditText usernameText = findViewById(R.id.userName1);
        EditText passwordText = findViewById(R.id.password);
        EditText emailText = findViewById(R.id.email);

        Button enterBtn = findViewById(R.id.submit);


        enterBtn.setOnClickListener(v -> presenter.trySignUp(emailText, usernameText, passwordText));
    }

    /**
     * This method opens the SetUpActivity View while passing in the profile
     */
    @Override
    public void openActivityWith() {
        finish();
        Intent setup = new Intent(this, SetupActivity.class);
        startActivity(setup);
    }

    /**
     * Display an error message given a message
     *
     * @param message String message to be displayed as error on call
     */
    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}