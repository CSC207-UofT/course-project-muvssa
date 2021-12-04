package com.example.fitappa.Profile;

import java.io.Serializable;

/**
 * This class is an entity class storing a lot of the User's information as Strings
 *
 * The method in the class involved getting and setting all the Strings
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @author Uthman
 *
 * @since 2.9
 */

class User implements Serializable {

    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String uniqueID;
    private String height;
    private String weight;

    /**
     * Constructor for a User that take an email and password as well as a unique identifier necessary
     * for database.
     *
     * @param email    The String email that is connected to the account
     * @param username The String username referring to the account
     * @param uniqueID The String unique identifier used to store the user in database and retrieve their info
     */
    User(String email, String username, String uniqueID) {
        this.username = username;
        this.email = email;
        this.uniqueID = uniqueID;
    }

    // Constructor necessary for Firebase
    @SuppressWarnings("unused")
    public User() {
    }

    /**
     * returns the User's username
     *
     * @return returns the String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the unique identifier for this user
     *
     * @return unique identifier for this user
     */
    public String getUniqueID() {
        return uniqueID;
    }

    /**
     * return a User's email
     *
     * @return return the String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter returns users height
     *
     * @return string height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets a users height
     *
     * @param height a string representing a users height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Getter returns users weight
     *
     * @return String weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets a users weight
     *
     * @param weight a string representing a users weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * Getter returns users first name
     *
     * @return String representing user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a users first name
     *
     * @param firstName a string representing the users first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter returns users last name
     *
     * @return a String representing the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a users last name
     *
     * @param lastName a string representing a users last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
