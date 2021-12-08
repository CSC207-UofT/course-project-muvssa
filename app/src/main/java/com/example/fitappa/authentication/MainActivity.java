package com.example.fitappa.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;
import com.example.fitappa.profile.DashboardActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

/**
 * This is the MainActivity, and is the first activity that is shown when the user starts the program.
 * <p>
 * This activity's methods gives the user two options, either login, or signup, and leads them to the corresponding
 * activities.
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Uthman
 * @author Souren
 * @author Abdullah
 * @since 0.2
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Check if user is logged in before creating this view
        checkAuth();

        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        setupButtons();

    }

    /**
     * Setup the buttons and listeners for this activity
     */
    private void setupButtons() {
        Button signUpBtn = findViewById(R.id.SignUp);
        Button loginBtn = findViewById(R.id.SignIn);

        //Define and attach click listener
        signUpBtn.setOnClickListener(v -> openSignUpPage());

        loginBtn.setOnClickListener(v -> openLogInPage());
    }

    /**
     * This method opens the DashboardActivity View
     */
    private void openDashboard() {
        finish();
        Intent home = new Intent(this, DashboardActivity.class);
        startActivity(home);
    }

    /**
     * This method checks if the user was already logged in. If they are already logged, go to DashboardActivity,
     * if not, continue.
     */
    private void checkAuth() {
        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // If a firebase user exists, then there is a user currently logged in, so proceed
        // to Dashboard
        if (firebaseUser != null) {
            openDashboard();
        }
    }

    /**
     * This method opens the SignUpActivity View
     */
    private void openSignUpPage() {
        Intent signUp = new Intent(this, SignUpActivity.class);
        startActivity(signUp);
    }

    /**
     * This method opens the LoginActivity View
     */
    private void openLogInPage() {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

}