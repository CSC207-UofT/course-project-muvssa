package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.Profile;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

public class FirebaseGateway implements Saveable, Serializable {

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
                .document(profile.getUniqueID())
                .set(o);
    }
}
