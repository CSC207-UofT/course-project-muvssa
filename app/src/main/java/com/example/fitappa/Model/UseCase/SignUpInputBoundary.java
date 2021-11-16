package com.example.fitappa.Model.UseCase;

public interface SignUpInputBoundary {
    /**
     * uses given user info to create a profile and save it to the database, and return the new profile object
     *
     * @param email    email of the user for a profile
     * @param username username of the user for a profile
     * @param password password of the user for a profile
     * @return return the Profile object created after saving it
     */
    Profile signUp(String email, String username, String password);
}
