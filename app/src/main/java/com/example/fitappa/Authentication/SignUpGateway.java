package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Profile.SaveProfileGateway;
import com.example.fitappa.Profile.Saveable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
// ToDo add author, since and other doc details

/**
 * This class is a gateway that deals with signing up a user with the database given an email, username, and password
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

                    // Create a profile with the user's info
                    Profile profile = new Profile(email, username, firebaseUser.getUid());

                    // Save the data of the profile to the database
                    Saveable gateway = new SaveProfileGateway();
                    profile.saveData(gateway);

                    // proceed to update activity
                    presenter.updateActivity();
                })
                .addOnFailureListener(e -> presenter.setError());
    }
}
