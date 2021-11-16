package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

public class SignUpUseCase implements SignUpInputBoundary {

    private final ReadWriter readWriter;

    /**
     * Constructor that takes a readWriter to determine what to read or write
     *
     * @param readWriter Interface which tells this class how you want to read and write data
     */
    public SignUpUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    /**
     * uses given user info to create a profile and save it to the database, and return the new profile object
     *
     * @param email    email of the user for a profile
     * @param username username of the user for a profile
     * @param password password of the user for a profile
     * @return return the Profile object created after saving it
     */
    @Override
    public Profile signUp(String email, String username, String password) {
        Profile profile = new Profile(username, password, email);
        readWriter.save(profile);
        return profile;
    }


}

