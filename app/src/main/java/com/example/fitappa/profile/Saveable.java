package com.example.fitappa.profile;

/**
 * This interface allows a class to save an object to the database.
 * It is implemented by any class that implements the save method that saves an object to a database.
 */
public interface Saveable {
    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    void save(Object o);
}
