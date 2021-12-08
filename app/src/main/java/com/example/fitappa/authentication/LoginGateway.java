package com.example.fitappa.authentication;

import com.google.firebase.auth.FirebaseAuth;

/**
 * This class is a gateway that accesses the database and signs in the user given their email and password
 * as credentials.
 * <p>
 * The class's methods allow users to fetch information from the database
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Uthman
 * @since 0.2
 */
class LoginGateway {
    private final AuthenticationPresenter presenter;

    /**
     * Constructor that takes in an AuthenticationPresenter abstract class and initializes it
     *
     * @param presenter AuthenticationPresenter abstract class to be used to access presenter methods
     */
    LoginGateway(AuthenticationPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Log in and authenticate user given credentials with Firebase
     *
     * @param email    email to log in with
     * @param password password to log in with
     */
    void login(String email, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                // If login succeeds, proceed to update activity from the presenter
                .addOnSuccessListener(authResult -> presenter.updateActivity())
                // If login fails, set an error with the presenter
                .addOnFailureListener(e -> presenter.setError());
    }
}
