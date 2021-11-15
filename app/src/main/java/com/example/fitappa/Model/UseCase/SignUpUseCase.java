package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

public class SignUpUseCase implements SignUpInputBoundary {

    private ReadWriter readWriter;

    public SignUpUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    @Override
    public Profile signUp(String email, String username, String password) {
        Profile profile = new Profile(username, password, email);
        readWriter.save(profile);
        return profile;
    }


}

