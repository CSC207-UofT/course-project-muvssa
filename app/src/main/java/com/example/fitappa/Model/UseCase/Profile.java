package com.example.fitappa.Model.UseCase;


import com.example.fitappa.Model.Entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profile implements Serializable {

    private User user;
    private FollowManager followManager;
    private List<Routine> routines;

    /**
     * Creates the main profile for one user
     *
     * @param email    this is the User's email
     * @param name     this is the User's username
     * @param password this is the User's password
     */
    public Profile(String email, String name, String password) {
        this.user = new User(name, password, email);
        this.followManager = new FollowManager(this.user);
        this.routines = new ArrayList<>();

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
     * gets who the User is following and who is following them
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
