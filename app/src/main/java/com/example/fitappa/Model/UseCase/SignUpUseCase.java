package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

import java.util.regex.Pattern;

public class SignUpUseCase implements SignUpInputBoundary {

    private ReadWriter readWriter;

    public SignUpUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    @Override
    public Profile signUp(String email, String username, String password) {
        Profile profile;
        if (verifyCredentials(email, username, password)) {
            profile = new Profile(username, password, email);
            readWriter.save(profile);
        } else {
            profile = null;
        }
        return profile;
    }

    /**
     * Make sure email, username, and password are valid entries
     * @param email
     * @param username
     * @param password
     * @return true iff credentials are valid
     */
    private boolean verifyCredentials(String email, String username, String password) {

        if (email == null || username == null || password == null || password.length() < 5 || username.length() < 3)
            return false;

//        String emailRegex = "^(.+)@(.+)$";
//
//        Pattern pat = Pattern.compile(emailRegex);
//
//        return pat.matcher(email).matches();
        return true;

    }
}

