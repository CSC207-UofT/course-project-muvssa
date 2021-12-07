package com.example.fitappa.Authentication;

/**
 * Constants to be used for Firebase methods
 *
 * The method in the class return String constants
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Uthman
 * @since 0.2
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
}
