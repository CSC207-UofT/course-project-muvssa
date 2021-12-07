package com.example.fitappa.Profile;

import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This is a gateway class to Firebase which lets a class save an object
 * <p>
 * Methods in this class help move profiles to the database
 * <p>
 * Documentation specifies what the methods do
 *
 * @author Uthman
 * @since 1.2
 */
public class SaveProfileGateway implements Saveable {
    private Profile profile;

    SaveProfileGateway() {

    }

    public SaveProfileGateway(String email, String username, String uniqueID) {
        profile = new Profile(email, username, uniqueID);
    }

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        DatabaseConstants constants = new DatabaseConstants();

        if (o != null) {
            this.profile = (Profile) o;
        }

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        database.collection(constants.getUsers())
                .document(profile.getUniqueID())
                .update(
                        constants.getUsername(), profile.getUsername(),
                        constants.getEmail(), profile.getEmail(),
                        constants.getFirstName(), profile.getFirstName(),
                        constants.getLastName(), profile.getLastName(),
                        constants.getHeight(), profile.getHeight(),
                        constants.getWeight(), profile.getWeight()
                );
    }
}
