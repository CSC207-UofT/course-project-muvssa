package com.example.fitappa.Authentication;

/**
 * Interface to be implemented by a class that contains a method that opens DashboardActivity
 * <p>
 * To be initialized by a class that needs to pass in a Profile and navigate to the DashboardActivity
 */
interface OpensActivityWithProfile {

    /**
     * Open the DashboardActivity and pass a profile to it
     */
    void openActivityWith();

    /**
     * Display an error message given a message
     *
     * @param message String message to be displayed as error on call
     */
    void showErrorMessage(String message);
}
