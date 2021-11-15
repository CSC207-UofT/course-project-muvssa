package com.example.fitappa.Model.UseCase;


import com.example.fitappa.Model.Entity.User;
import fitappfiles.FollowManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable {

    private final User user;
    private final FollowManager followManager;
    private ArrayList<Routine> routines;

    /**
     * Creates the main profile for one user
     * @param name this is the User's username
     * @param password this is the User's password
     * @param email this is the User's email
     */
    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.followManager = new FollowManager(this.user);
        this.routines = new ArrayList<Routine>();

        // Temporary Hardcode
        this.routines.add(new Routine("My routine", "A new routine"));
        this.routines.add(new Routine("My routine2", "A new routine"));


    }

    public ArrayList<Routine> getRoutines() {
        return this.routines;
    }

    /**
     * gets the User who owns the profile
     * @return a User class
     */
    public User getUser() {
        return user;

    }

    /**
     * gets who the User is following and who is following them
     * @return returns a HashMap of people User is following
     */
    public FollowManager getProfileFollow(){
        return followManager;
    }

    public void addRoutine(Routine r) {
        this.routines.add(r);
    }
}
