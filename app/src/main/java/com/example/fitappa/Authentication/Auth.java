package com.example.fitappa.Authentication;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fitappa.Profile.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;

class Auth implements Authenticator {
    private final FirebaseAuth mAuth;
    private final View view;
    private final Saveable gateway;

    /**
     * Constructor that takes a view and initializes a FirebaseAuth
     *
     * @param view OpensHome view to be used when ready to go home
     */
    Auth(View view) {
        this.mAuth = FirebaseAuth.getInstance();
        this.view = view;
        gateway = new FirebaseGateway();
    }

    /**
     * Verify that the input is valid, and set an error message if invalid.
     * If input is valid, authenticate user and login with Firebase
     *
     * @param emailText    Text representing the email that the user entered
     * @param passwordText Text representing the password that the user entered
     */
    @Override
    public void login(EditText emailText, EditText passwordText) {
        // Convert EditText to String
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        // Set error if email or password are empty
        if (email.isEmpty()) {
            emailText.setError("Please fill out username");
            emailText.requestFocus();
            return;
        } else if (password.isEmpty()) {
            passwordText.setError("Please fill out password");
            passwordText.requestFocus();
            return;
        }

        authenticateLogin(email, password);
    }

    /**
     * Log in and authenticate user given credentials with Firebase
     *
     * @param email    email to log in with
     * @param password password to log in with
     */
    private void authenticateLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = authResult.getUser();
                    String uniqueID = firebaseUser != null ? firebaseUser.getUid() : "";

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("users")
                            .document(uniqueID)
                            .get()
                            .addOnSuccessListener(documentSnapshot -> {
                                // Retrieve the profile from Firebase document
                                Profile profile = null;
                                try {
                                    profile = documentSnapshot.toObject(Profile.class);
                                } catch (RuntimeException ignored) {

                                }

                                // Set the gateway since it's not being retrieved by Firebase
                                if (profile != null) {
                                    profile.setGateway(gateway);
                                }

                                // Pass the new profile into the view
                                updateUI(profile);
                            });
                })
                .addOnFailureListener(e -> Toast.makeText(view.getContext(),
                        "Error. Incorrect email or password. \nPlease try again.",
                        Toast.LENGTH_LONG).show());
    }

    /**
     * Make sure email, username, and password are valid entries and authenticate and sign up the user with Firebase
     *
     * @param emailText    email address for user
     * @param usernameText username for user
     * @param passwordText password for user
     */
    @Override
    public void signUp(EditText emailText, EditText usernameText, EditText passwordText) {

        // convert EditText variables to string
        String email = emailText.getText().toString();
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        // build verification regex to verify email
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pat = Pattern.compile(emailRegex);

        // Display error if username, password, or email are invalid
        if (username.isEmpty()) {
            usernameText.setError("Please fill out username");
            usernameText.requestFocus();
            return;
        } else if (username.length() < 5) {
            usernameText.setError("Please make your username at least 5 characters long");
            usernameText.requestFocus();
            return;
        } else if (password.isEmpty()) {
            passwordText.setError("Please fill out password");
            passwordText.requestFocus();
            return;
        } else if (password.length() < 6) {
            passwordText.setError("Please make your password at least 6 characters long");
            passwordText.requestFocus();
            return;
        } else if (email.isEmpty()) {
            emailText.setError("Please fill out email");
            emailText.requestFocus();
            return;
        } else if (!pat.matcher(email).matches()) {
            emailText.setError("Please enter a proper email address");
            emailText.requestFocus();
            return;
        }

        authenticateSignUp(email, username, password);
    }

    /**
     * Sign up and authenticate user given credentials using Firebase
     *
     * @param email    email to sign up with
     * @param username username to create new profile
     * @param password password to sign up with
     */
    private void authenticateSignUp(String email, String username, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = authResult.getUser();

                    // return if a user was not made
                    if (firebaseUser == null)
                        return;

                    // Create a profile with the user's info
                    Profile profile = new Profile(email, username, firebaseUser.getUid());
                    profile.setGateway(gateway);

                    // Save the data of the profile to the database
                    profile.saveData();

                    // Update the view with the new profile
                    updateUI(profile);
                })
                .addOnFailureListener(e -> Toast.makeText(view.getContext(),
                        "Error. Email already in use. \nPlease try again.",
                        Toast.LENGTH_LONG).show());
    }

    /**
     * Update UI given a profile
     *
     * @param profile profile to update UI with
     */
    @Override
    public void updateUI(Profile profile) {
        view.openHome(profile);
    }

    /**
     * Dependency Inversion
     * <p>
     * Interface to be implemented by the Activity that deals with Login and Signup
     */
    interface View {

        /**
         * This method opens the HomeActivity while passing in the profile.
         *
         * @param profile represents the Profile of the authenticated user
         */
        void openHome(Profile profile);

        /**
         * Return the application context to be used to display 'Toast' text to user.
         *
         * @return Context instance for an activity
         */
        Context getContext();

    }

}
