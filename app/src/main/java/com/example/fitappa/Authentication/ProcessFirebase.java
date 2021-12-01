package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
import com.google.firebase.firestore.DocumentSnapshot;

/**
 * This class processing information received from Firebase and retrieves the profile from a DocumentSnapshot
 * object. It then calls the openDashboard method from the view and passes in the new profile.
 */
class ProcessFirebase {
    private final ActivityUpdater presenter;

    /**
     * Constructor that takes in a OpensActivityWithProfile view which contains a method that opens the DashboardActivity
     *
     * @param view OpensActivityWithProfile interface representing a view that contains a method which opens the Dashboard
     */
    ProcessFirebase(ActivityUpdater view) {
        this.presenter = view;
    }

    /**
     * Retrieve the profile from a given DocumentSnapshot object and call the openDashboard method from the view
     * with the retrieved profile
     *
     * @param documentSnapshot DocumentSnapshot object retrieved from Firebase which contains a Profile
     */
    void updateViewWithProfileFrom(DocumentSnapshot documentSnapshot) {
        Profile profile = null;
        try {
            profile = documentSnapshot.toObject(Profile.class);
        } catch (RuntimeException ignored) {

        }

        // Set the gateway since it's not being retrieved by Firebase
        if (profile != null) {
            Saveable gateway = new FirebaseGateway();
            profile.setGateway(gateway);
        }

        presenter.updateUI(profile);
    }
}
