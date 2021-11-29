package com.example.fitappa.Profile;

/**
 * To be implemented by a gateway class that retrieves a profile from the database given a username
 * <p>
 * To be initialized by a presenter class that needs to retrieve a profile from the database
 */
interface GetsProfile {
    /**
     * Queries the database and returns the user that matches the username given
     *
     * @param username username for user wanted
     */
    void retrieveProfile(String username);
}
