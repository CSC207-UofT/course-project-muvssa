package com.example.fitappa.Authentication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This class is a gateway that accesses the database and signs in the user given their email and password
 * as credentials.
 */
class LoginGateway {
    private final GatewayInteractor presenter;
    private final DatabaseConstants constants;

    /**
     * Constructor that takes in an GatewayInteractor abstract class and initializes it
     *
     * @param presenter GatewayInteractor abstract class to be used to access presenter methods
     */
    LoginGateway(GatewayInteractor presenter) {
        this.presenter = presenter;
        constants = new DatabaseConstants();
    }

    /**
     * Log in and authenticate user given credentials with Firebase
     *
     * @param email    email to log in with
     * @param password password to log in with
     */
    void login(String email, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult ->
                {
                    FirebaseUser firebaseUser = authResult.getUser();
                    String uniqueID = firebaseUser != null ? firebaseUser.getUid() : "";

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(constants.getUsersCollection())
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
