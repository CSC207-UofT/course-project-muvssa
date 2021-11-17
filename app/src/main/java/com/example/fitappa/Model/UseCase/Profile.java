package com.example.fitappa.Model.UseCase;


import com.example.fitappa.Model.Entity.User;
import com.example.fitappa.Model.Gateway.Database;
import com.example.fitappa.Model.Gateway.FirebaseDB;
import com.google.firebase.auth.FirebaseAuth;

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
        this(new User(email, name, password));
    }

    /**
     * Creates the main profile for one user
     *
     * @param user User object representing one user
     */
    public Profile(User user) {
        this.user = user;
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
     * Save this profile to a database
     */
    public void saveData() {
        Database database = new FirebaseDB();
        database.save(this);
        FirebaseAuth.getInstance().signOut();
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
