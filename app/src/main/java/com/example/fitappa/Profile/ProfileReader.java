package com.example.fitappa.Profile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;
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
    private final ViewProfilePresenter presenter;

    /**
     * Constructor that takes in an interface that allows this class to update the presenter with a retrieved profile
     *
     * @param presenter Interface that is used to update the presenter
     */
    ProfileReader(ViewProfilePresenter presenter) {
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
                    Map<String, String> userMap = (Map<String, String>) documentSnapshot.get("user");

                    if (userMap == null) return;

                    String username = (String) userMap.get("username");
                    String email = (String) userMap.get("email");
                    String firstName = (String) userMap.get("firstName");
                    String lastName = (String) userMap.get("lastName");
                    String weight = (String) userMap.get("weight");
                    String height = (String) userMap.get("height");

                    Profile profile = new Profile(email, username, firebaseUser.getUid());
                    profile.setUserExtraInfo(weight, height, firstName, lastName);

                    presenter.loadProfile(profile);
                });
    }
}
