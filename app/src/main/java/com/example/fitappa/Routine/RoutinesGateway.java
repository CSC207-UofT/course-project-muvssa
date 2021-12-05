package com.example.fitappa.Routine;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.StartWorkoutPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Gateway class for Routines that implements Loadable and Saveable so it can load and save
 * routines from the database.
 *
 * @author Uthman
 * @layer Gateway (Third)
 * @since 0.5
 */
public class RoutinesGateway implements Loadable, Saveable {

    private final DocumentReference documentReference;
    private StartWorkoutPresenter presenter;

    public RoutinesGateway(StartWorkoutPresenter presenter) {
        this();
        this.presenter = presenter;
    }

    public RoutinesGateway() {
        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseConstants constants = new DatabaseConstants();

        // get the document reference for the current user
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * load an object from a database
     */
    @Override
    public void load() {
        documentReference
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    Routines routines = new Routines();
                    try {
                        routines = documentSnapshot.get("routines", Routines.class);
                    } catch (RuntimeException ignored) {

                    }

                    if (routines != null) {
                        presenter.doSomethingWithRoutines(routines.getRoutines());
                    }
                });
    }

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        // Initialize Routines object to pass in appropriate format
        Routines routines = new Routines();
        for (Object object : (List) o) {
            routines.add((Routine) object);
        }

        documentReference.update("routines", routines);
    }


    // Defines a way to retrieve data from firebase and cast to a List<Routine>
    private static class Routines implements Serializable {
        private final List<Routine> routines;


        /**
         * Constructor needed to be public for firebase to cast List into Routines
         * Initialize list of routines to ArrayList
         */
        public Routines() {
            routines = new ArrayList<>();
        }

        /**
         * Method required to be public for Firebase.
         * Gets the routines list from this instance.
         *
         * @return List of Routine
         */
        public List<Routine> getRoutines() {
            return routines;
        }

        private void add(Routine routine) {
            routines.add(routine);
        }
    }
}
