package com.example.fitappa.Profile;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This class is used for retrieving a profile from the database given a username, and updating the presenter
 * with the new profile if it was found
 */
class ProfileReader {
    UpdatesViewProfile presenter;

    /**
     * Constructor that takes in an interface that allows this class to update the presenter with a retrieved profile
     *
     * @param presenter Interface that is used to update the presenter
     */
    ProfileReader(UpdatesViewProfile presenter) {
        this.presenter = presenter;
    }

    /**
     * Get a profile from the database and return it
     *
     * @param username username for user wanted
     */
    void retrieveProfile(String username) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    // Set profile to null in case no profile is found from search
                    Profile profile = null;

                    // Loop through all the profiles to search for the username
                    for (DocumentSnapshot document : queryDocumentSnapshots.getDocuments()) {
                        // Get the username for this profile
                        String retrievedUsername = (String) document.get("user.username");
                        if (retrievedUsername != null && retrievedUsername.equals(username)) {
                            // If username matches the given username, retrieve the Profile object
                            try {
                                profile = document.toObject(Profile.class);
                            } catch (RuntimeException ignored) {

                            }
                        }
                    }

                    // update UI with profile if it was received or null if it wasn't
                    updatePresenter(profile);
                });
    }

    /**
     * Update the presenter with a retrieved profile from database
     *
     * @param profile Profile that was retrieved from the database, or null if no profile was found
     */
    private void updatePresenter(Profile profile) {
        presenter.updateViewProfileWith(profile);
    }
}
