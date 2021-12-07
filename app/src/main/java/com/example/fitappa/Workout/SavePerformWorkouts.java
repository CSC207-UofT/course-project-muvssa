package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.Core.PerformWorkout;
import com.example.fitappa.constants.DatabaseConstants;
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

public class SavePerformWorkouts implements Saveable {
    private final DocumentReference documentReference;
    private final TrackWorkoutPresenter presenter;

    /**
     * Saves performed workout information to the database
     * @param presenter presenter information on workouts come from
     */
    public SavePerformWorkouts(TrackWorkoutPresenter presenter) {
        this.presenter = presenter;
        DatabaseConstants constants = new DatabaseConstants();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        this.documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * Save object into some database
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            List<String> performedWorkouts = null;
            try {
                performedWorkouts = (List<String>) documentSnapshot.get("Performed Workouts");
            } catch (RuntimeException ignored) {
            }

            if (performedWorkouts == null)
                performedWorkouts = new ArrayList<>();


            PerformWorkout performWorkout = (PerformWorkout) o;
            Objects.requireNonNull(performedWorkouts).add(performWorkout.toString());

            documentReference.update("Performed Workouts", performedWorkouts);
        });
    }
}
