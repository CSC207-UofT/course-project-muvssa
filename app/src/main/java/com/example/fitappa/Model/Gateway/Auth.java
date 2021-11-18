package com.example.fitappa.Model.Gateway;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fitappa.Model.Entity.User;
import com.example.fitappa.Model.UseCase.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;

public class Auth implements Authenticator {
    private final FirebaseAuth mAuth;
    private final View view;

    /**
     * Constructor that takes a view and initializes a FirebaseAuth
     *
     * @param view OpensHome view to be used when ready to go home
     */
    public Auth(View view) {
        this.mAuth = FirebaseAuth.getInstance();
        this.view = view;
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
                    FirebaseUser firebaseUser = authResult.getUser();
                    assert firebaseUser != null;

                    // Create a user with the firebase unique ID assigned to their login
                    User user = new User(email, username, password, firebaseUser.getUid());
                    // Create a profile with the user
                    Profile profile = new Profile(user);

                    // Update the view with the new profile
                    updateUI(profile);
                })
                .addOnFailureListener(e -> Toast.makeText(view.getContext(),
                        "Error. Email already in use. \nPlease try again.",
                        Toast.LENGTH_LONG).show());
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
                    FirebaseUser firebaseUser = authResult.getUser();
                    assert firebaseUser != null;
                    String uniqueID = firebaseUser.getUid();

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("users")
                            .document(uniqueID)
                            .get()
                            .addOnSuccessListener(documentSnapshot -> {
                                Profile profile = documentSnapshot.toObject(Profile.class);
                                updateUI(profile);
                            });
                })
                .addOnFailureListener(e -> Toast.makeText(view.getContext(),
                        "Error. Incorrect email or password. \nPlease try again.",
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

    public void runLogin(EditText emailText, EditText passwordText) {
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

        login(email, password);
    }

    /**
     * Make sure email, username, and password are valid entries
     *
     * @param emailText    email address for user
     * @param usernameText username for user
     * @param passwordText password for user
     */
    public void runSignUp(EditText emailText, EditText usernameText, EditText passwordText) {

        // convert EditText variables to string
        String email = emailText.getText().toString();
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        // build verification regex to verify email
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pat = Pattern.compile(emailRegex);

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

        signUp(email, username, password);
    }

    public interface View {
        void openHome(Profile profile);

        Context getContext();
    }

}
