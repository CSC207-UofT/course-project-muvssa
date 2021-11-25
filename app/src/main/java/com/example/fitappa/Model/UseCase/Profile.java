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
    }

    // empty constructor necessary for Firebase
    public Profile() {
    }

    public List<Routine> getRoutines() {
        return this.routines;
    }

    /**
     * replaces the current routine list
     *
     * @param routines a list of routine objects
     */
    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }

    /**
     * Get the username of the user for this profile
     *
     * @return String representing the user's username
     */
    public String getUsername() {
        return this.user.getUsername();
    }

    /**
     * Get the email of the user for this profile
     *
     * @return String representing the user's email
     */
    public String getEmail() {
        return this.user.getEmail();
    }

    /**
     * Get the unique ID of the user for this profile
     *
     * @return String representing the user's unique identifier
     */
    public String getUniqueID() {
        return this.user.getUniqueID();
    }

    /**
     * Save this profile to a database through the gateway
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

    /**
     * Adds a routine to the list
     *
     * @param r a routine to be added
     */
    public void addRoutine(Routine r) {
        this.routines.add(r);
    }
}
