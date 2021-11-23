package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.Profile;

interface Authenticator {
    /**
     * Update UI given a profile
     *
     * @param profile profile to update UI with
     */
    void updateUI(Profile profile);

    /**
     * Sign up given credentials using a database
     *
     * @param email    email to sign up with
     * @param username username to create new profile
     * @param password password to sign up with
     */
    void signUp(String email, String username, String password);

    /**
     * Log in user given credentials with a database
     *
     * @param email    email to log in with
     * @param password password to log in with
     */
    void login(String email, String password);
}
