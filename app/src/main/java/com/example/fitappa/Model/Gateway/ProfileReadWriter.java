package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.Profile;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileReadWriter implements ReadWriter {

    private final FirebaseFirestore db;

    public ProfileReadWriter() {
        db = FirebaseFirestore.getInstance();
    }

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        db.collection("users").add(o);
    }

    /**
     * Read data from a database given an email and password representing the user to search for
     *
     * @param email    email of profile to search for
     * @param password password of profile to search for
     * @param useCase  use case class to pass profile to when found
     */
    @Override
    public void read(String email, String password, LoginInputBoundary useCase) {
        db.collection("users")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots ->
                {
                    for (DocumentSnapshot document : queryDocumentSnapshots.getDocuments()) {
                        // loop through all the 'profiles' inside the database
                        Profile newProfile = document.toObject(Profile.class);  // convert to Profile object

                        assert newProfile != null;  // make sure a profile is received
                        if (newProfile.getUser().getEmail().equals(email) &&    // if this is the profile we want
                                newProfile.getUser().getPassword().equals(password)) {
                            // TODO: Find alternate solution to this
                            useCase.updateProfile(newProfile);
                            break; // exit early in case there is a duplicate profile in database
                        }
                    }
                });
    }
}
