package com.example.fitappa.Profile;

import android.util.Log;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.io.Serializable;
// ToDo add author, since and other doc details

/**
 * This is a gateway class to Firebase which lets a class save an object
 */
public class SaveProfileGateway implements Saveable, Serializable {

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

        Log.d("test123", "inside SaveProfileGateway.save");
        database.collection(constants.getUsersCollection())
                .document(profile.retrieveUniqueID())
                .set(profile, SetOptions.mergeFields("user"));
    }
}
