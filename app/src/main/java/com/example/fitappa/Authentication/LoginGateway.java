package com.example.fitappa.Authentication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

class LoginGateway {
    private final ActivityUpdater presenter;

    LoginGateway(ActivityUpdater presenter) {
        this.presenter = presenter;
    }

    /**
     * Log in and authenticate user given credentials with Firebase
     *
     * @param email    email to log in with
     * @param password password to log in with
     */
    void authenticateLogin(String email, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult ->
                {
                    FirebaseUser firebaseUser = authResult.getUser();
                    String uniqueID = firebaseUser != null ? firebaseUser.getUid() : "";

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("users")
                            .document(uniqueID)
                            .get()
                            .addOnSuccessListener(documentSnapshot -> {
                                ProcessFirebase processFirebase = new ProcessFirebase(presenter);
                                processFirebase.updateViewWithProfileFrom(documentSnapshot);
                            });
                })
                .addOnFailureListener(e -> presenter.setError());
    }
}
