package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

class SignUpGateway {
    AuthenticationPresenter presenter;

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
                    Saveable gateway = new FirebaseGateway();
                    profile.setGateway(gateway);

                    // Save the data of the profile to the database
                    profile.saveData();

                    // Update the presenter with the new profile
                    presenter.updateUI(profile);
                })
                .addOnFailureListener(e -> presenter.setError());
    }
}
