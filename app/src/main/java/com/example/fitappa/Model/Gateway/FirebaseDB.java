package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.Profile;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseDB implements Database {

    private final FirebaseFirestore database;

    /**
     * Constructor that initializes the Firestore database
     */
    public FirebaseDB() {
        database = FirebaseFirestore.getInstance();
    }

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        Profile profile = (Profile) o;
        database.collection("users").document(profile.getUser().getUniqueID()).set(profile);
    }
}
