package com.example.fitappa.Workout.CRUD;

import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.example.fitappa.constants.DatabaseConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Objects;

public class WorkoutTemplateGateway implements Loadable, Saveable {
    private final LoadsWorkoutTemplate presenter;
    private final String workoutName;
    private final String routineName;
    private final DocumentReference documentReference;

    public WorkoutTemplateGateway(LoadsWorkoutTemplate presenter, String workoutName, String routineName) {
        this.presenter = presenter;
        this.routineName = routineName;
        this.workoutName = workoutName;

        DatabaseConstants constants = new DatabaseConstants();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    /**
     * load an object from a database
     */
    @Override
    public void load() {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            try {
                FirebaseWorkoutGetter firebaseWorkoutGetter = new FirebaseWorkoutGetter(routineName);
                List<WorkoutTemplate> workoutTemplates = firebaseWorkoutGetter.getWorkoutTemplates(documentSnapshot);

                for (WorkoutTemplate workoutTemplate : workoutTemplates) {
                    if (workoutTemplate.getName().equals(workoutName)) {
                        presenter.loadWorkoutTemplate(workoutTemplate);
                    }
                }
            } catch (RuntimeException e) {
                presenter.loadWorkoutTemplate(new WorkoutTemplate(""));
            }
        });
    }

    /**
     * Save workout template into firebase
     *
     * @param o object to be converted to workout template and saved
     */
    @Override
    public void save(Object o) {
        WorkoutTemplate newWorkoutTemplate = (WorkoutTemplate) o;
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            // Get list of routines corresponding to the routineName
            FirebaseWorkoutGetter firebaseWorkoutGetter = new FirebaseWorkoutGetter(routineName);
            List<WorkoutTemplate> workoutTemplates = firebaseWorkoutGetter.getWorkoutTemplates(documentSnapshot);

            // Add given workout template to the list
            workoutTemplates.add(newWorkoutTemplate);

            // Save list with added workout template to the database
            documentReference.update("routines." + routineName, workoutTemplates);
        });
    }
}
