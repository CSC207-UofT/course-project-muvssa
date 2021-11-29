package com.example.fitappa.Profile;

/**
 * To be implemented by a presenter that updates the view with a new profile
 * <p>
 * To be initialized by a gateway class that updates the presenter with a profile retrieved from database
 */
interface UpdatesViewProfile {
    /**
     * If a non-empty profile was passed in, then a profile was successfully found,
     * so open the view profile page for it.
     * If the profile passed in was null, then the profile wasn't found,
     * so update UI accordingly
     *
     * @param profile Profile that represents the profile found from the search, or null if the profile wasn't found
     */
    void updateViewProfileWith(Profile profile);
}
