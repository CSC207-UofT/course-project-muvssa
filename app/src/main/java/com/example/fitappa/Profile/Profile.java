package com.example.fitappa.Profile;


import com.example.fitappa.Exercise.Exercise.DefaultExercises;
import com.example.fitappa.Routine.Routine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the central storage for all relevant entities and use cases for the third and fourth layers of
 * clean architecture. It contains a User, FollowManager, list of Routines, Saveable gateway, and DefaultExercises.
 * <p>
 * It implements Serializable so that it may be saved into a database or used to start a new intent and pass its data.
 */
public class Profile implements Serializable {

    private User user;
    private FollowManager followManager;
    private List<Routine> routines;
    private Saveable gateway;
    private DefaultExercises defaultExercises;

    /**
     * Constructor that creates a new profile given a user's information
     *
     * @param email    Email address for user
     * @param username Username for the user
     * @param uniqueID Unique identifier representing the User (necessary for database query)
     */
    public Profile(String email, String username, String uniqueID) {
        this.user = new User(email, username, uniqueID);
        this.followManager = new FollowManager(this.user);
        this.routines = new ArrayList<>();
        this.defaultExercises = new DefaultExercises();
    }

    // empty constructor necessary for Firebase
    public Profile() {
    }

    /**
     * Get the list of routines for this profile
     *
     * @return List of Routine of this profile
     */
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
     * Get the object containing default exercises for this profile
     *
     * @return DefaultExercises object containing a list of exercises
     */
    public DefaultExercises getDefaultExercises() {
        return defaultExercises;
    }

    /**
     * Set the gateway for this profile so that it can be saved
     *
     * @param gateway Saveable interface representing a gateway with a save method
     */
    public void setGateway(Saveable gateway) {
        this.gateway = gateway;
    }

    /**
     * Necessary method for Firebase
     * Gets the current user of this profile instance
     *
     * @return User for this profile
     */
    public User getUser() {
        return user;
    }

    /**
     * Get the username of the user for this profile
     *
     * @return String representing the user's username
     */
    String getUsername() {
        return this.user.getUsername();
    }

    /**
     * Get the unique ID of the user for this profile
     *
     * @return String representing the user's unique identifier
     */
    public String retrieveUniqueID() {
        return this.user.getUniqueID();
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

    /**
     * Set the user's extra information
     *
     * @param weight    String weight of the user
     * @param height    String height of the user
     * @param firstName String first name of the user
     * @param lastName  String last name of the user
     */
    public void setUserExtraInfo(String weight, String height, String firstName, String lastName) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setHeight(height);
        user.setWeight(weight);
    }

    /**
     * gets a string of the users weight
     * @return returns string of their weight
     */
    String getUserWeight(){
        return user.getWeight();
    }

    /**
     * gets a string of the users height
     * @return returns string of their height
     */
    String getUserHeight(){
        return user.getHeight();
    }

    /**
     * gets a string of the users first name
     * @return returns string of their first name
     */
    String getUserFirstName(){
        return user.getFirstName();
    }

    /**
     * gets a string of the users last name
     * @return returns string of their last name
     */
    String getUserLastName(){
        return user.getLastName();
    }

    /**
     * Save this profile to a database through the gateway
     */
    public void saveData() {
        gateway.save(this);
    }
}
