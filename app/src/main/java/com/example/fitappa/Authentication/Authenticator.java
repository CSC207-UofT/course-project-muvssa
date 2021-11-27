package com.example.fitappa.Authentication;

import android.widget.EditText;
import com.example.fitappa.Profile.Profile;

interface Authenticator {
    /**
     * Update UI given a profile
     *
     * @param profile profile to update UI with
     */
    void updateUI(Profile profile);

    /**
     * Make sure email, username, and password are valid entries and authenticate and sign up the user with Firebase
     *
     * @param emailText    email address for user
     * @param usernameText username for user
     * @param passwordText password for user
     */
    void signUp(EditText emailText, EditText usernameText, EditText passwordText);

    /**
     * Verify that the input is valid, and set an error message if invalid.
     * If input is valid, authenticate user and login with Firebase
     *
     * @param emailText    Text representing the email that the user entered
     * @param passwordText Text representing the password that the user entered
     */
    void login(EditText emailText, EditText passwordText);
}
