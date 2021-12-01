package com.example.fitappa.Authentication;

import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * This is a presenter for the SignupActivity.
 * This class is an authentication presenter since it authenticates the user given some credentials.
 * It also determines what error message to display to the user.
 */
class SignUpPresenter extends AuthenticationPresenter {
    private final SignUpGateway gateway;

    /**
     * Constructor that takes an OpensActivityWithProfile interface and initializes it
     *
     * @param view OpensActivityWithProfile interface which is implemented by an Activity
     */
    SignUpPresenter(OpensActivityWithProfile view) {
        super(view);
        this.gateway = new SignUpGateway(this);
    }

    /**
     * Make sure email, username, and password are valid entries and authenticate and sign up the user with Firebase
     *
     * @param emailText    email address for user
     * @param usernameText username for user
     * @param passwordText password for user
     */
    void trySignUp(EditText emailText, EditText usernameText, EditText passwordText) {

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

        gateway.signUp(email, username, password);
    }

    /**
     * Set an error when the database fails to retrieve the profile
     */
    @Override
    public void setError() {
        view.showErrorMessage("Email already in use. \nPlease try again");
    }
}
