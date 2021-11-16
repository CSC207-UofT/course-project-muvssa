package com.example.fitappa.Model.UseCase;

public interface LoginInputBoundary {

    /**
     * Update the profile once it has been changed in the database listener
     *
     * @param profile the profile received from the database listener
     */
    void updateProfile(Profile profile);

    /**
     * Take user credentials and retrieve the profile corresponding to the user from the database to return
     *
     * @param email    email of profile to search for
     * @param password password of profile to search for
     * @return new profile found from database
     */
    Profile login(String email, String password);

}
