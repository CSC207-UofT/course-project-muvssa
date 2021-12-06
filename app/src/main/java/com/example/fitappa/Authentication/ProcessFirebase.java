package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.FollowManager;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Profile.User;
import com.google.firebase.firestore.DocumentSnapshot;
// ToDo add author, since and other doc details

/**
 * This class processes information received from Firebase and retrieves the profile from a DocumentSnapshot
 * object. It then calls the openDashboard method from the view and passes in the new profile.
 */
public class ProcessFirebase {
    private final GatewayInteractor presenter;

    /**
     * Constructor that takes in a OpensActivityWithProfile view which contains a method that opens the DashboardActivity
     *
     * @param view OpensActivityWithProfile interface representing a view that contains a method which opens the Dashboard
     */
    public ProcessFirebase(GatewayInteractor view) {
        this.presenter = view;
    }

    /**
     * Retrieve the profile from a given DocumentSnapshot object and call the openDashboard method from the view
     * with the retrieved profile
     *
     * @param documentSnapshot DocumentSnapshot object retrieved from Firebase which contains a Profile
     */
    public void updateViewWithProfileFrom(DocumentSnapshot documentSnapshot) {
        try {
            // Get the user from the database
            User retrievedUser = documentSnapshot.get("user", User.class);

            // Get the FollowManager object from the database
            FollowManager retrievedFollowerManager = documentSnapshot.get("followManager", FollowManager.class);

            // Construct a profile from the retrieved data
            Profile profile = new Profile(retrievedUser, retrievedFollowerManager);

            // Update the presenter with the new profile
            presenter.updateActivity(profile);

        } catch (RuntimeException e) {
            // If firebase fails to return data, set an error
            presenter.setError();
        }
    }
}
