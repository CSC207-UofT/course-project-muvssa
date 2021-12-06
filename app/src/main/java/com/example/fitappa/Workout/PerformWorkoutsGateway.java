package com.example.fitappa.Workout;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.Core.PerformWorkout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerformWorkoutsGateway implements Loadable, Saveable {
    private final DocumentReference documentReference;
    private final TrackWorkoutPresenter presenter;

    public PerformWorkoutsGateway(TrackWorkoutPresenter presenter) {
        this.presenter = presenter;
        DatabaseConstants constants = new DatabaseConstants();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        this.documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * load an object from a database
     */
    @Override
    public void load() {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            @SuppressWarnings("unchecked")
            List<String> performedWorkoutsStrings = (List<String>) documentSnapshot.get("Performed Workouts");

            List<PerformWorkout> performWorkouts = new ArrayList<>();
            for (String performedWorkoutSting : performedWorkoutsStrings) {
//                PerformWorkout performWorkout = new PerformWorkout(performedWorkoutSting);
//                performWorkouts.add(performWorkout);
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
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            List<String> performedWorkouts;
            try {
                performedWorkouts = (List<String>) documentSnapshot.get("Performed Workouts");
            } catch (RuntimeException e) {
                performedWorkouts = new ArrayList<>();
            }

            PerformWorkout performWorkout = (PerformWorkout) o;
            Objects.requireNonNull(performedWorkouts).add(performWorkout.toString());

            documentReference.update("Performed Workouts", performedWorkouts);
        });
    }
}
