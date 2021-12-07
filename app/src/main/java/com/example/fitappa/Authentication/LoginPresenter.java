package com.example.fitappa.Authentication;

import android.widget.EditText;

/**
 * This is a presenter for the LoginActivity.
 * <p>
 * This class is an authentication presenter since it is a presenter for an activity that
 * authenticates the user.
 * <p>
 * It also determines what error message to display to the user.
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Uthman
 * @since 0.2
 */
class LoginPresenter extends AuthenticationPresenter {
    private final LoginGateway gateway;

    /**
     * Constructor that takes an OpensActivityWithProfile interface and initializes it
     *
     * @param view OpensActivityWithProfile interface which is implemented by an Activity
     */
    LoginPresenter(OpensActivityWithProfile view) {
        super(view);
        this.gateway = new LoginGateway(this);
    }

    /**
     * Try to log in the user given an email and password by checking if they match a criteria. If they match, then
     * pass the email and password to a gateway to log in.
     *
     * @param emailText    EditText representing the text for email that the user entered
     * @param passwordText EditText representing the text for password that the user entered
     */
    void tryLogin(EditText emailText, EditText passwordText) {
        // Convert EditText to String
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

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

        gateway.login(email, password);
    }

    /**
     * Set an error when the database fails to retrieve the profile
     */
    @Override
    public void setError() {
        view.showErrorMessage("Incorrect email or password. \nPlease try again.");
    }

}
