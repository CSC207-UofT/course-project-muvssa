package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;

/**
 * This class is an abstract class extended by presenters that update an activity after retrieving a profile
 * from the database.
 *
 * The class's methods use an interface which represents a view that allows this class to call its method and open
 * and activity with the profile.
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Uthman
 * @since 0.2
 */
public abstract class GatewayInteractor {
    /**
     * An interface which contains a method to open an activity given a profile and display an error given a message
     */
    protected final OpensActivityWithProfile view;

    /**
     * Constructor that takes in an OpensActivityWithProfile interface and initializes it
     *
     * @param view OpensActivityWithProfile interface that contains methods to set error and open activity with profile
     */
    protected GatewayInteractor(OpensActivityWithProfile view) {
        this.view = view;
    }

    /**
     * Update an activity by passing in a profile to it
     *
     * @param profile Profile retrieved from database to go to next activity with
     */
    protected void updateActivity(Profile profile) {
        view.openActivityWith(profile);
    }

    /**
     * Set an error when the database fails to retrieve the profile
     */
    public abstract void setError();
}
