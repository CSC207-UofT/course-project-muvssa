package com.example.fitappa.Profile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

/**
 * This class is used for retrieving a profile from the database given a username, and updating the presenter
 * with the new profile if it was found
 * <p>
 * The methods in this class work with the database to retrieve information
 * <p>
 * The Documentation explains the specification of each method
 *
 * @author Uthman
 * @since 0.3
 */
class ProfileReader {
    private final LoadsProfile presenter;

    /**
     * Constructor that takes in an interface that allows this class to update the presenter with a retrieved profile
     *
     * @param presenter Interface that is used to update the presenter
     */
    ProfileReader(LoadsProfile presenter) {
        this.presenter = presenter;
    }

    /**
     * Get a profile from the database and return it
     */
    void retrieveProfile() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DocumentReference documentReference = FirebaseFirestore.getInstance()
                .collection("users")
                .document(Objects.requireNonNull(firebaseUser).getUid());

        documentReference
                .get()
                .addOnSuccessListener(documentSnapshot -> {

                    String username = (String) documentSnapshot.get("username");
                    String email = (String) documentSnapshot.get("email");
                    String firstName = (String) documentSnapshot.get("firstName");
                    String lastName = (String) documentSnapshot.get("lastName");
                    String weight = (String) documentSnapshot.get("weight");
                    String height = (String) documentSnapshot.get("height");

                    Profile profile = new Profile(email, username, firebaseUser.getUid());
                    profile.setExtraInfo(weight, height, firstName, lastName);

                    presenter.loadProfile(profile);
                });
    }
}
