package com.example.fitappa.Model.Gateway;

public interface ReadWriter {
    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    void save(Object o);

    /**
     * Read data from a database given an email and password representing the user to search for
     *
     * @param email    email of profile to search for
     * @param password password of profile to search for
     */
    void read(String email, String password);
}
