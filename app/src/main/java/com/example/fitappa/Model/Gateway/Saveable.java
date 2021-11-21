package com.example.fitappa.Model.Gateway;

public interface Saveable {
    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    void save(Object o);
}
