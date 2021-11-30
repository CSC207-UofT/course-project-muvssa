package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;
import com.google.firebase.firestore.DocumentSnapshot;

public class ProcessFirebase {

    public void updateViewWithProfileFrom(DocumentSnapshot documentSnapshot) {
        Profile profile = null;
        try {
            profile = documentSnapshot.toObject(Profile.class);
        } catch (RuntimeException ignored) {

        }

        // Set the gateway since it's not being retrieved by Firebase
        if (profile != null) {
            Saveable gateway = new FirebaseGateway();
            profile.setGateway(gateway);
        }
    }
}
