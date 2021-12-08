package com.example.fitappa.profile;

import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

/**
 * This class is used for retrieving a profile from the database given a username, and updating
 * the presenter with the new profile if it was found
 * <p>
 * The methods in this class work with the database to retrieve information
 * <p>
 * The Documentation explains the specification of each method
 *
 * @author Uthman
 * @since 0.3
 */
class ProfileReader implements Loadable {
    private final LoadsProfile presenter;

    /**
     * Constructor that takes in an interface that allows this class to update the presenter with
     * a retrieved profile
     *
     * @param presenter Interface that is used to update the presenter
     */
    ProfileReader(LoadsProfile presenter) {
        this.presenter = presenter;
    }

    /**
     * Get a profile from the database and return it
     */
    @Override
    public void load() {
        DatabaseConstants constants = new DatabaseConstants();

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DocumentReference documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsers())
                .document(Objects.requireNonNull(firebaseUser).getUid());

        documentReference
                .get()
                .addOnSuccessListener(documentSnapshot -> {

                    String username = (String) documentSnapshot.get(constants.getUsername());
                    String email = (String) documentSnapshot.get(constants.getEmail());
                    String firstName = (String) documentSnapshot.get(constants.getFirstName());
                    String lastName = (String) documentSnapshot.get(constants.getLastName());
                    String weight = (String) documentSnapshot.get(constants.getWeight());
                    String height = (String) documentSnapshot.get(constants.getHeight());

                    Profile profile = new Profile(email, username, firebaseUser.getUid());
                    // Set extra info
                    profile.setFirstName(firstName);
                    profile.setLastName(lastName);
                    profile.setHeight(height);
                    profile.setWeight(weight);

                    presenter.loadProfile(profile);
                });
    }
}
