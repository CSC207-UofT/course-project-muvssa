package com.example.fitappa.Model.UseCase;


import com.example.fitappa.Model.Entity.User;
import com.example.fitappa.Model.Gateway.Saveable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profile implements Serializable {

    private User user;
    private FollowManager followManager;
    private List<Routine> routines;
    private Saveable gateway;

    /**
     * Creates the main profile for one user
     *
     * @param user User object representing one user
     */
    public Profile(User user, Saveable gateway) {
        this.user = user;
        this.followManager = new FollowManager(this.user);
        this.routines = new ArrayList<>();
        this.gateway = gateway;

        // Temporary Hardcode (for testing purposes)
        this.routines.add(new Routine("My routine", "A new routine"));
        this.routines.add(new Routine("My routine2", "A new routine"));
    }

    // empty constructor necessary for Firebase
    public Profile() {
    }

    public List<Routine> getRoutines() {
        return this.routines;
    }

    /**
     * gets the User who owns the profile
     *
     * @return a User class
     */
    public User getUser() {
        return user;
    }

    /**
     * Save this profile to a gateway
     */
    public void saveData() {
        gateway.save(this);
    }

    /**
     * Gets who the User is following and who is following them
     *
     * @return returns a HashMap of people User is following
     */
    public FollowManager getFollowManager() {
        return followManager;
    }

    public void addRoutine(Routine r) {
        this.routines.add(r);
    }
}
