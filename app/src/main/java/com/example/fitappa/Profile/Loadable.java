package com.example.fitappa.Profile;

/**
 * This interface allows a class to load an object from the database.
 * It is implemented by any class that implements the load method that loads an object from database
 */
public interface Loadable {
    /**
     * load an object from a database
     */
    void load();
}
