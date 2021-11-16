package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;
import com.example.fitappa.Model.UseCase.Profile;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Objects;

public class ProfileReadWriter implements ReadWriter {

    private final FirebaseFirestore db;

    public ProfileReadWriter() {
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void save(Object o) {
        db.collection("users").add(o);
    }

    @Override
    public void read(String email, String password, LoginInputBoundary useCase) {
        db.collection("users")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<DocumentSnapshot> documents = Objects.requireNonNull(task.getResult()).getDocuments();
                        for (DocumentSnapshot document : documents) {
                            Profile newProfile = document.toObject(Profile.class);
                            assert newProfile != null;
                            if (newProfile.getUser().getEmail().equals(email) && newProfile.getUser().getPassword().equals(password)) {
                                useCase.updateProfile(newProfile);
                                break; // exit early in case there is a duplicate profile in database
                            } else {
                                // make profile null if it doesn't match anything in database
                                useCase.updateProfile(null);

                            }
                        }
                    }
                });
    }
}
