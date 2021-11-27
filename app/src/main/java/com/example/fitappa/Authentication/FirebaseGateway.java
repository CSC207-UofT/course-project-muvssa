package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

class FirebaseGateway implements Saveable, Serializable {

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        Profile profile = (Profile) o;
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection("users")
                .document(profile.retrieveUniqueID())
                .set(o);
    }
}
