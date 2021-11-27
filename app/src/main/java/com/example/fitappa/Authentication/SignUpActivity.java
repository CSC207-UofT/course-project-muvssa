package com.example.fitappa.Authentication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Profile.DashboardActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements Auth.View {
    private EditText usernameText;
    private EditText passwordText;
    private EditText emailText;

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

        usernameText = findViewById(R.id.userName1);
        passwordText = findViewById(R.id.password);
        emailText = findViewById(R.id.email);
        Button enter = findViewById(R.id.submit);

        Authenticator auth = new Auth(this);

        enter.setOnClickListener(v -> auth.signUp(emailText, usernameText, passwordText));
    }


    /**
     * This method opens the HomeActivity View while passing in the profile
     *
     * @param profile represents the Profile that was created
     */
    @Override
    public void openHome(Profile profile) {
        Intent home = new Intent(this, DashboardActivity.class);
        home.putExtra("profile", profile);
        startActivity(home);
    }

    /**
     * Return the application context to be used to display 'Toast' text to user.
     *
     * @return Context instance for an activity
     */
    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}