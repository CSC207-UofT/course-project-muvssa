package com.example.fitappa.Workout.Core;

import com.example.fitappa.Authentication.DatabaseConstants;
import com.example.fitappa.Exercise.Exercise.Category;
import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Profile.Loadable;
import com.example.fitappa.Profile.Saveable;
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
    private final LoadsWorkoutTemplates presenter;
    private final String routineName;

    public WorkoutTemplatesGateway(LoadsWorkoutTemplates presenter, String routineName) {

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

                // Get object representing list of routines
                @SuppressWarnings("unchecked")
                Map<String, List<Map<String, Object>>> routineMap = (Map<String, List<Map<String, Object>>>) documentSnapshot.get("routines");

                // Get object representing a routine
                List<Map<String, Object>> workoutTemplateList = Objects.requireNonNull(routineMap).get(routineName);

                // initialize workout templates
                List<WorkoutTemplate> workoutTemplates = new ArrayList<>();

                // Loop through the workout templates object and input workout templates to the list
                for (Map<String, Object> workoutMap : Objects.requireNonNull(workoutTemplateList)) {

                    // Get the workout's name
                    String workoutName = (String) workoutMap.get("name");

                    // Get object representing the exercise templates list
                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> exerciseTemplatesList = (List<Map<String, Object>>) workoutMap.get("exercises");

                    List<ExerciseTemplate> exerciseTemplates = new ArrayList<>();
                    // Loop through and create the exerciseTemplates list
                    for (Map<String, Object> exerciseMap : Objects.requireNonNull(exerciseTemplatesList)) {
                        String name = (String) exerciseMap.get("name");
                        Integer sets = (Integer) exerciseMap.get("sets");
                        String categoryString = (String) exerciseMap.get("category");
                        Category category = Category.valueOf(categoryString);

                        // Add each exerciseTemplate to the list
                        ExerciseTemplate exerciseTemplate = new ExerciseTemplate(name, integerToInt(sets), category);
                        exerciseTemplates.add(exerciseTemplate);
                    }

                    // Create the WorkoutTemplate object and add it to the workoutTemplates list
                    WorkoutTemplate workoutTemplate = new WorkoutTemplate(workoutName, exerciseTemplates);
                    workoutTemplates.add(workoutTemplate);
                }

                // pass the retrieved workout templates to the presenter
                presenter.loadWorkoutTemplates(workoutTemplates);


            } catch (RuntimeException e) {
                // If there is a failure from the database, pass in an empty list
                presenter.loadWorkoutTemplates(new ArrayList<>());
            }
        });
    }

    private int integerToInt(Integer integer) {
        if (integer == null) {
            return 0;
        } else {
            return integer;
        }
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
