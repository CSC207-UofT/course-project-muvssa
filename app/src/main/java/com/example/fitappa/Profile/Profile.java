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
 * <p>
 * Since 2.6
 */
class Profile implements Serializable {

    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String uniqueID;
    private String height;
    private String weight;

    /**
     * Constructor that creates a new profile given a user's information
     *
     * @param email    Email address for user
     * @param username Username for the user
     * @param uniqueID Unique identifier representing the User (necessary for database query)
     */
    Profile(String email, String username, String uniqueID) {
        this.email = email;
        this.username = username;
        this.uniqueID = uniqueID;
    }

    // empty constructor necessary for Firebase
    @SuppressWarnings("unused")
    public Profile() {
    }

    /**
     * Get the email of this user
     *
     * @return String representing this users email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the username of the user for this profile
     *
     * @return String representing the user's username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Get the unique ID of the user for this profile
     *
     * @return String representing the user's unique identifier
     */
    public String getUniqueID() {
        return this.uniqueID;
    }

    /**
     * Set the user's extra information
     *
     * @param weight    String weight of the user
     * @param height    String height of the user
     * @param firstName String first name of the user
     * @param lastName  String last name of the user
     */
    void setExtraInfo(String weight, String height, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
    }

    /**
     * gets a string of the users weight
     *
     * @return returns string of their weight
     */
    public String getWeight() {
        return this.weight;
    }

    /**
     * gets a string of the users height
     *
     * @return returns string of their height
     */
    public String getHeight() {
        return this.height;
    }

    /**
     * gets a string of the users first name
     *
     * @return returns string of their first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * gets a string of the users last name
     *
     * @return returns string of their last name
     */
    public String getLastName() {
        return this.lastName;
    }
}
