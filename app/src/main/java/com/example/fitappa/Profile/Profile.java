package com.example.fitappa.Profile;

import java.io.Serializable;
/**
 * This class is the central storage for all relevant entities and use cases for the third and fourth layers of
 * clean architecture. It contains a User, FollowManager, list of Routines, Saveable gateway, and DefaultExercises.
 * <p>
 * It implements Serializable so that it may be saved into a database or used to start a new intent and pass its data.
 *
 * @author Souren
 * @author Uthman
 * @author Abdullah
 *
 * Since 2.6
 */
public class Profile implements Serializable {

    private User user;
    private FollowManager followManager;

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
    }

    // empty constructor necessary for Firebase
    public Profile() {
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
    public void saveData(Saveable gateway) {
        gateway.save(this);
    }
}
