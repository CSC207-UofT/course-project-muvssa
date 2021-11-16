package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

public class LoginUseCase implements LoginInputBoundary {

    ReadWriter readWriter;
    Profile newProfile;

    /**
     * Constructor that takes a readWriter to tell the class how to read and write the data
     *
     * @param readWriter Interface readWriter that tells the class how to read or write data
     */
    public LoginUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    /**
     * Update the profile once it has been changed in the database listener
     *
     * @param profile the profile received from the database listener
     */
    public void updateProfile(Profile profile) {
        this.newProfile = profile;
    }

    /**
     * Take user credentials and retrieve the profile corresponding to the user from the database to return
     *
     * @param email    email of profile to search for
     * @param password password of profile to search for
     * @return new profile found from database
     */
    @Override
    public Profile login(String email, String password) {
        readWriter.read(email, password, this);
        this.newProfile = new Profile("Loading...", email, password);
        return this.newProfile;
    }
}
