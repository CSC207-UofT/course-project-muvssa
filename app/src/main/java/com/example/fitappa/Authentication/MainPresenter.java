package com.example.fitappa.Authentication;

/**
 * This is a presenter for the MainActivity which is also an AuthenticationPresenter because it deals with retrieving
 * information from the database and validating the user.
 */
class MainPresenter extends AuthenticationPresenter {

    /**
     * Constructor that takes in an OpensActivityWithProfile interface that represents an Activity and initializes
     * the parent class with it
     *
     * @param view OpensActivityWithProfile interface that represents an Activity
     */
    MainPresenter(OpensActivityWithProfile view) {
        super(view);
    }

    /**
     * Set an error when the database fails to retrieve the profile
     */
    @Override
    public void setError() {
        view.showErrorMessage("Oops, something went wrong.");
    }

}
