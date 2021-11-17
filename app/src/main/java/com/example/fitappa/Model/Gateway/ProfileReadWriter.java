package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.View.GoesHome;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileReadWriter implements ReadWriter, UpdatesView {

    private final FirebaseFirestore db;
    private final GoesHome view;

    public ProfileReadWriter(GoesHome view) {
        db = FirebaseFirestore.getInstance();
        this.view = view;
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
     */
    @Override
    public void read(String email, String password) {
        db.collection("users")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots ->
                {
                    for (DocumentSnapshot document : queryDocumentSnapshots.getDocuments()) {
                        // loop through all the 'profiles' inside the database
                        Profile profile = document.toObject(Profile.class);  // convert to Profile object

                        assert profile != null;
                        if (profile.getUser().getEmail().equals(email) &&    // if this is the profile we want
                                profile.getUser().getPassword().equals(password)) {
                            // TODO: Make this if statement only happen once
                            updateUI(profile);
                        }
                    }
                });
    }

    @Override
    public void updateUI(Profile profile) {
        view.openHome(profile);
    }

}
