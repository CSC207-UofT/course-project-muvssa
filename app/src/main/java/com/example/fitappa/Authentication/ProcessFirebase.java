package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
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
        Profile profile = null;

        try {
            profile = documentSnapshot.toObject(Profile.class);
        } catch (RuntimeException e) {
            presenter.setError();
        }

        if (profile != null) {
            // Update presenter with retrieved profile
            presenter.updateActivity(profile);
        }

    }
}
