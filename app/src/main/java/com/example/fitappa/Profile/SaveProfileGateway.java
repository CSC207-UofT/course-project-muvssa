package com.example.fitappa.Profile;

import android.util.Log;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This is a gateway class to Firebase which lets a class save an object
 *
 * Methods in this class help move profiles to the database
 *
 * Documentation specifies what the methods do
 *
 * @author Uthman
 *
 * @since 1.2
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

        Log.d("test123", "profile is: " + profile.getUsername());
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        database.collection(constants.getUsersCollection())
                .document(profile.getUniqueID())
                .set(profile);
    }
}
