package com.example.fitappa.workout.track_workout;

import com.example.fitappa.constants.DatabaseConstants;
import com.example.fitappa.profile.Saveable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class save performed workouts
 * <p>
 * The method in the class save workouts from a list onto a DocumentReference
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.3
 */

class SavePerformWorkouts implements Saveable {
    private final DocumentReference documentReference;

    /**
     * Saves performed workout information to the database
     */
    SavePerformWorkouts() {
        DatabaseConstants constants = new DatabaseConstants();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        this.documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsers())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * Save object into some database
     * Precondition: o can be casted to a String
     *
     * @param o object to be saved
     */
    @SuppressWarnings("unchecked")
    @Override
    public void save(Object o) {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            DatabaseConstants constants = new DatabaseConstants();

            List<String> performedWorkouts = null;
            try {
                performedWorkouts = (List<String>) documentSnapshot.get(constants.getPerformedWorkouts());
            } catch (RuntimeException ignored) {
            }

            if (performedWorkouts == null)
                performedWorkouts = new ArrayList<>();


            String performWorkoutString = (String) o;
            Objects.requireNonNull(performedWorkouts).add(performWorkoutString);

            documentReference.update(constants.getPerformedWorkouts(), performedWorkouts);
        });
    }
}
