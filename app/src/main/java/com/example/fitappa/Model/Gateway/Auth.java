package com.example.fitappa.Model.Gateway;

import android.widget.EditText;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.View.GoesHome;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Auth implements Authenticator {
    private final FirebaseAuth mAuth;
    private final GoesHome view;

    public Auth(FirebaseAuth mAuth, GoesHome view) {
        this.mAuth = mAuth;
        this.view = view;
    }

    /**
     * Make sure email, username, and password are valid entries
     *
     * @param emailText    email address for user
     * @param usernameText username for user
     * @param passwordText password for user
     * @return true iff credentials are valid
     */
    public boolean verifyCredentials(EditText emailText, EditText usernameText, EditText passwordText) {
        String email = emailText.getText().toString();
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pat = Pattern.compile(emailRegex);

        if (username.isEmpty()) {
            usernameText.setError("Please fill out username");
            usernameText.requestFocus();
            return false;
        } else if (username.length() < 5) {
            usernameText.setError("Please make your username at least 5 characters long");
            usernameText.requestFocus();
            return false;
        } else if (password.isEmpty()) {
            passwordText.setError("Please fill out password");
            passwordText.requestFocus();
            return false;
        } else if (password.length() < 6) {
            passwordText.setError("Please make your password at least 6 characters long");
            passwordText.requestFocus();
            return false;
        } else if (email.isEmpty()) {
            emailText.setError("Please fill out email");
            emailText.requestFocus();
            return false;
        } else if (!pat.matcher(email).matches()) {
            emailText.setError("Please enter a proper email address");
            emailText.requestFocus();
            return false;
        }
        return true;

    }

    /**
     * Sign up given credentials using Firebase
     *
     * @param email    email to sign up with
     * @param username username to create new profile
     * @param password password to sign up with
     */
    @Override
    public void signUp(String email, String username, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Profile profile = new Profile(email, username, password);
                    updateUI(profile);
                });
    }

    /**
     * Log in user given credentials with Firebase
     *
     * @param email    email to log in with
     * @param password password to log in with
     */
    @Override
    public void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Profile profile = new Profile(email, "testing", password);
                    updateUI(profile);
                });
    }

    @Override
    public void updateUI(Profile profile) {
        view.openHome(profile);
    }
}
