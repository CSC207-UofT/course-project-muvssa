package com.example.fitappa.Profile;

import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.firestore.FirebaseFirestore;
// ToDo add author, since and other doc details

/**
 * This is a gateway class to Firebase which lets a class save an object
 */
public class SaveProfileGateway implements Saveable {
    private Profile profile;

    public SaveProfileGateway() {

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

        database.collection(constants.getUsersCollection())
                .document(profile.getUniqueID())
                .set(profile);
    }
}
