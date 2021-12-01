package com.example.fitappa.Authentication;

import android.widget.EditText;

class LoginPresenter extends ActivityUpdater {
    private final LoginGateway gateway;

    LoginPresenter(OpensActivityWithProfile view) {
        super(view);
        this.gateway = new LoginGateway(this);
    }


    void runLogin(EditText emailText, EditText passwordText) {
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

        gateway.authenticateLogin(email, password);
    }

}
