package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.SaveProfileGateway;
import com.example.fitappa.Profile.Saveable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * This class is a gateway that deals with signing up a user with the database given an email, username, and password
 *
 * Methods in this class move information to the database
 *
 * Documentation in this class specifies what methods do
 *
 * @author Uthman
 * @version 1.1
 */
class SignUpGateway {
    private final AuthenticationPresenter presenter;

    /**
     * Constructor that takes an AuthenticationPresenter abstract class which represents a presenter for sign up
     *
     * @param presenter AuthenticationPresenter abstract class which represents a presenter for sign up
     */
    SignUpGateway(AuthenticationPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Sign up and authenticate user given credentials using Firebase
     *
     * @param email    email to sign up with
     * @param username username to create new profile
     * @param password password to sign up with
     */
    void signUp(String email, String username, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = authResult.getUser();

                    // return if a user was not made
                    if (firebaseUser == null)
                        return;

                    // Save the data of the profile to the database
                    Saveable gateway = new SaveProfileGateway(email, username, firebaseUser.getUid());
                    // pass null since we don't have access to the full profile object
                    gateway.save(null);

                    // proceed to update activity
                    presenter.updateActivity();
                })
                .addOnFailureListener(e -> presenter.setError());
    }
}
