package com.example.fitappa.Profile;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Authentication.GatewayInteractor;
import com.example.fitappa.Authentication.ProcessFirebase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This class is used for retrieving a profile from the database given a username, and updating the presenter
 * with the new profile if it was found
 *
 * The methods in this class work with the database to retrieve information
 *
 * The Documentation explains the specification of each method
 *
 * @author Uthman
 * Since
 */
class ProfileReader {
    private final GatewayInteractor presenter;

    /**
     * Constructor that takes in an interface that allows this class to update the presenter with a retrieved profile
     *
     * @param presenter Interface that is used to update the presenter
     */
    ProfileReader(GatewayInteractor presenter) {
        this.presenter = presenter;
    }

    /**
     * Get a profile from the database and return it
     *
     * @param username username for user wanted
     */
    void retrieveProfile(String username) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DatabaseConstants constants = new DatabaseConstants();

        db.collection(constants.getUsersCollection())
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    // Loop through all the profiles to search for the username
                    for (DocumentSnapshot document : queryDocumentSnapshots.getDocuments()) {
                        // Get the username for this profile
                        String retrievedUsername = (String) document.get(constants.getUsernameDocument());
                        if (retrievedUsername != null && retrievedUsername.equals(username)) {
                            ProcessFirebase gateway = new ProcessFirebase(presenter);
                            gateway.updateViewWithProfileFrom(document);
                            return;
                        }
                    }
                    presenter.setError();
                })
                .addOnFailureListener(e -> presenter.setError());
    }
}
