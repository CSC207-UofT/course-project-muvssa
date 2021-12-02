package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Profile.Saveable;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

/**
 * This is a gateway class to Firebase which lets a class save an object
 */
class SaveProfileGateway implements Saveable, Serializable {

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        DatabaseConstants constants = new DatabaseConstants();
        Profile profile = (Profile) o;
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        database.collection(constants.getUsersCollection())
                .document(profile.retrieveUniqueID())
                .set(o);
    }
}
