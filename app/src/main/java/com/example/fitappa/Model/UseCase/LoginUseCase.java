package com.example.fitappa.Model.UseCase;

import android.util.Log;
import com.example.fitappa.Model.Gateway.ReadWriter;

public class LoginUseCase implements LoginInputBoundary {

    ReadWriter readWriter;
    Profile newProfile;

    public LoginUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    public void updateProfile(Profile profile) {
        this.newProfile = profile;
    }

    @Override
    public Profile login(String email, String password)  {
        readWriter.read(email, password, this);
        this.newProfile = new Profile("Loading...", email, password);
        return this.newProfile;
    }
}
