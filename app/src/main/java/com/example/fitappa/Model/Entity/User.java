package com.example.fitappa.Model.Entity;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String email;
    private String uniqueID;

    /**
     * Constructor for a User class, takes in all necessary variables needed to make a User
     *
     * @param email    The String email that is connected to the account
     * @param username The String username referring to the account
     * @param password The String password used to log in to the account
     */
    public User(String email, String username, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String email, String username, String password, String uniqueID) {
        this(email, username, password);
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
     * return a User's password
     *
     * @return return the String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Change a User's password
     *
     * @param password the new String password
     */
    public void setPassword(String password) {
        this.password = password;
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


}
