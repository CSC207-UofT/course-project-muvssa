package com.example.fitappa.Authentication;

/**
 * Constants to be used for Firebase methods
 */
public class DatabaseConstants {

    /**
     * Get the collection name for users
     *
     * @return String representing collection name for users
     */
    public String getUsersCollection() {
        return "users";
    }

    /**
     * Get the collection name for exercises
     *
     * @return String representing collection name for exercises
     */
    public String getExercisesCollection() {
        return "exercises";
    }

    /**
     * Get the name for the document that contains username
     *
     * @return String representing name for the document that contains username
     */
    public String getUsernameDocument() {
        return "user.username";
    }
}
