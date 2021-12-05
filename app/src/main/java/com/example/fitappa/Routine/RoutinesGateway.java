package com.example.fitappa.Routine;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.CRUD.AddRoutinePresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Gateway class for Routines that implements Loadable and Saveable so it can load and save
 * routines from the database.
 *
 * @author Uthman
 * @layer Gateway (Third)
 * @since 0.5
 */
public class RoutinesGateway implements Loadable, Saveable {

    private final AddRoutinePresenter presenter;
    private final FirebaseUser firebaseUser;
    private final CollectionReference collectionReference;

    public RoutinesGateway(AddRoutinePresenter presenter) {
        DatabaseConstants constants = new DatabaseConstants();
        this.presenter = presenter;
        this.firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        this.collectionReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection());
    }

    /**
     * load an object from a database
     */
    @Override
    public void load() {
        collectionReference
                .document(firebaseUser.getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    Routines routines = documentSnapshot.get("routines", Routines.class);

                    if (routines != null) {
                        // Call presenter method and pass retrieved routines
                        presenter.doSomethingWithRoutines(routines.getRoutines());
                    } else {
                        // Pass null to presenter method if there was a failure in retrieving routines
                        presenter.doSomethingWithRoutines(null);
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
        CollectionReference collectionReference = FirebaseFirestore.getInstance()
                .collection("users");

        collectionReference.document(firebaseUser.getUid())
                .set(o);
    }


    // Defines a way to retrieve data from firebase and cast to a List<Routine>
    private static class Routines {
        private final List<Routine> routines = new ArrayList<>();

        private List<Routine> getRoutines() {
            return routines;
        }
    }
}
