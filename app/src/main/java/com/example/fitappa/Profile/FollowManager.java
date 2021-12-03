package com.example.fitappa.Profile;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is a UseCase class meant to facilitate a Profile class's followers
 *
 * The methods in the class add followers to different peoples profiles
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @since 1.1
 */

class FollowManager implements Serializable {
    private final User user;
    private final Map<String, FollowManager> following;
    private final Map<String, FollowManager> followers;

    /**
     * Hold all follow related commands within a profile
     *
     * @param user take in the profiles' owner/User
     */
    FollowManager(User user) {
        this.user = user;
        this.following = new HashMap<>();
        this.followers = new HashMap<>();
    }

    // Constructor necessary for firebase
    @SuppressWarnings("unused")
    public FollowManager() {
        user = new User();
        followers = new HashMap<>();
        following = new HashMap<>();
    }

    /**
     * get who the User is following
     *
     * @return returns a HashMap of who they are following
     */
    public Map<String, FollowManager> getFollowing() {
        return following;
    }

    /**
     * get who is following the User
     *
     * @return returns a HashMap of who they are getting followed by
     */
    public Map<String, FollowManager> getFollowers() {
        return followers;
    }

    /**
     * private class that gives this class a follower
     *
     * @param person A ProfileFollow class containing a User is receiving a follower
     */
    private void addFollower(FollowManager person) {
        this.followers.put(user.getUsername(), person);
    }

    /**
     * Has this class follow another ProfileFollow
     *
     * @param person A ProfileFollow class containing a User is receiving
     *               this class's User as a follower
     */
    void follow(FollowManager person) {
        this.following.put(person.user.getUsername(), person);
        person.addFollower(this);

    }

    /**
     * Get the number of followers for this instance
     *
     * @return integer representing the amount of followers
     */
    int followerCount() {
        return this.followers.size();
    }

    /**
     * Get the number of people this instance is following
     *
     * @return integer representing the amount of people this instance is following
     */
    int followingCount() {
        return this.following.size();
    }
}
