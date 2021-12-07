package com.example.fitappa.Workout;

import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * This class loads performed workouts
 * <p>
 * The method in the class load workouts from a documentSnapshot onto a list
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.3
 */

public class LoadPerformWorkouts implements Loadable {
    private final DocumentReference documentReference;
    private final WorkoutLogPresenter presenter;

    /**
     * loads performed workout information to the database
     * @param presenter presenter information on workouts come from
     */
    public LoadPerformWorkouts(WorkoutLogPresenter presenter) {
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

            if (performedWorkoutsStrings == null)
                performedWorkoutsStrings = new ArrayList<>();

            presenter.inititalizeView(performedWorkoutsStrings);
        });
    }
}
