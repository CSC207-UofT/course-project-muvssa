package com.example.fitappa.Workout.Core;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
import com.example.fitappa.Workout.CRUD.AddWorkoutPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WorkoutTemplatesGateway implements Loadable, Saveable {
    private final DocumentReference documentReference;
    private final AddWorkoutPresenter presenter;
    private final String routineName;

    public WorkoutTemplatesGateway(AddWorkoutPresenter presenter, String routineName) {

        this.routineName = routineName;

        this.presenter = presenter;
        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseConstants constants = new DatabaseConstants();

        // get the document reference for the current user
        documentReference = FirebaseFirestore.getInstance()
                .collection(constants.getUsersCollection())
                .document(Objects.requireNonNull(firebaseUser).getUid());
    }

    @Override
    public void load() {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            try {

                Map<String, List<Map<String, Object>>> routineMap = (Map<String, List<Map<String, Object>>>) documentSnapshot.get("routines");

                List<Map<String, Object>> workoutTemplateList = Objects.requireNonNull(routineMap).get(routineName);

                List<WorkoutTemplate> workoutTemplates = new ArrayList<>();

                for (Map<String, Object> map : Objects.requireNonNull(workoutTemplateList)) {
                    WorkoutTemplate workoutTemplate = new WorkoutTemplate((String) map.get("name"), (List<ExerciseTemplate>) map.get("exercises"));
                    workoutTemplates.add(workoutTemplate);
                }

                presenter.loadWorkoutTemplates(workoutTemplates);


            } catch (RuntimeException e) {
                presenter.loadWorkoutTemplates(new ArrayList<>());
            }
        });
    }

    @Override
    public void save(Object o) {
        // init
        List<WorkoutTemplate> templates = new ArrayList<>();

        //noinspection rawtypes
        for (Object object : (List) o) {
            templates.add((WorkoutTemplate) object);
        }

        documentReference.update("routines." + routineName, templates);
    }
}
