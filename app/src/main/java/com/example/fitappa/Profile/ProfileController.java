package com.example.fitappa.Profile;

import java.util.Observable;

/**
 * This class is a controller class meant to open facilitate an observer observable design patter to add followers
 * to peoples profiles.
 *
 * The method in the class implement an observer observable design pattern
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @since 0.6
 */

class ProfileController extends Observable {

    // declaring a list of integer
    private final Profile profile;
    private Profile otherProfile;

    /**
     * Initializes a profile
     *
     * @param profile type profile that represents the user's profile
     */
    ProfileController(Profile profile) {
        this.profile = profile;
    }

    /**
     * Gets the user's profile
     *
     * @return the user's profile as type Profile
     */

    Profile getFollow1() {
        return this.profile;
    }

    /**
     * Gets another user's profile
     *
     * @return another user's profile as type Profile
     */

    Profile getFollow2() {
        return this.otherProfile;
    }

    /**
     * Adds a profile to the follower list of another profile
     *
     * @param profile type profile that represents a profile
     */
    void setFollow(Profile profile) {
        this.profile.getFollowManager().follow(profile.getFollowManager());
        this.otherProfile = profile;
        setChanged();
        notifyObservers();
    }

}