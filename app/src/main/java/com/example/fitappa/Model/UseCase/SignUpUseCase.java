package com.example.fitappa.Model.UseCase;

import android.util.Log;
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
            Log.d("Tag", "Credentials Passed");
            profile = new Profile(username, password, email);
            readWriter.save(profile);
        } else {
            profile = null;
            Log.d("Tag", "Credentials Failed");
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

//        if (password.length() < 5 || username.length() < 3)
//            return false;

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pat = Pattern.compile(emailRegex);

        return pat.matcher(email).matches();

    }
}

