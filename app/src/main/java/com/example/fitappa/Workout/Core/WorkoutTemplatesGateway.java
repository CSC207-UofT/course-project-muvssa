package com.example.fitappa.Workout.Core;

import androidx.annotation.NonNull;

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

/**
 * Gateway class for WorkoutTemplate that implements Loadable and Saveable so it can load and save
 * workout templates from the database.
 *
 * @author Uthman
 * @layer Gateway (Third)
 * @since 0.5
 */
public class WorkoutTemplatesGateway implements Loadable, Saveable {
    private final DocumentReference documentReference;
    private final LoadsWorkoutTemplates presenter;
    private final String routineName;

    /**
     * Constructor that takes in an interface LoadsWorkoutTemplates so that it can present
     * the retrieved data from the load method and a routine name to save and load workout
     * templates from and to a specific routine
     *
     * @param presenter   LoadsWorkoutTemplates interface that is implemented by a presenter
     * @param routineName String representing the specific routine's name to access
     */
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

    /**
     * load in workout templates from the database for the current user logged in
     */
    @Override
    public void load() {
        documentReference.get().addOnSuccessListener(documentSnapshot -> {
            try {

                List<WorkoutTemplate> workoutTemplates = getWorkoutTemplates(documentSnapshot);

                // pass the retrieved workout templates to the presenter
                presenter.loadWorkoutTemplates(workoutTemplates);


            } catch (RuntimeException e) {
                // If there is a failure from the database, pass in an empty list
                presenter.loadWorkoutTemplates(new ArrayList<>());
            }
        });
    }

    /**
     * Accesses the document snapshot from firebase and retrieves the list of workout templates
     *
     * @param documentSnapshot DocumentSnapshot object from firebase to be casted to retrieve data
     * @return List of WorkoutTemplate representing the workout templates for a specific routine
     */
    @NonNull
    private List<WorkoutTemplate> getWorkoutTemplates(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        // Get object representing list of routines
        @SuppressWarnings("unchecked")
        Map<String, List<Map<String, Object>>> routineMap = (Map<String, List<Map<String, Object>>>) documentSnapshot.get("routines");

        // Get object representing a routine
        List<Map<String, Object>> workoutTemplateList = Objects.requireNonNull(routineMap).get(routineName);

        // initialize workout templates
        List<WorkoutTemplate> workoutTemplates = new ArrayList<>();

        // Loop through the workout templates object and input workout templates to the list
        for (Map<String, Object> workoutMap : Objects.requireNonNull(workoutTemplateList)) {

            WorkoutTemplate workoutTemplate = getWorkoutTemplate(workoutMap);
            workoutTemplates.add(workoutTemplate);
        }
        return workoutTemplates;
    }

    /**
     * Get the workout template from a map representing a workoutTemplate
     *
     * @param workoutTemplateMap Map of String to Object representing a workout template
     * @return a WorkoutTemplate object constructor from the map received
     */
    @NonNull
    private WorkoutTemplate getWorkoutTemplate(Map<String, Object> workoutTemplateMap) {
        // Get the workout's name
        String workoutName = (String) workoutTemplateMap.get("name");

        // Get object representing the exercise templates list
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> exerciseTemplatesList = (List<Map<String, Object>>) workoutTemplateMap.get("exercises");

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
        return workoutTemplate;
    }

    /**
     * Convert an Integer object to int by returning 0 if the Integer given is null
     *
     * @param integer Integer object to be returned as int
     * @return int representing the Integer converted to int
     */
    private int integerToInt(Integer integer) {
        if (integer == null) {
            return 0;
        } else {
            return integer;
        }
    }

    /**
     * Save workout templates into the database for the current user with a specific routine
     *
     * @param o object to be saved
     */
    @Override
    public void save(Object o) {
        // init
        List<WorkoutTemplate> workoutTemplates = new ArrayList<>();

        //noinspection rawtypes
        for (Object object : (List) o) {
            workoutTemplates.add((WorkoutTemplate) object);
        }

        // Update the routine with the workoutTemplates
        // String is using dot notation to access the specific routine.
        // Ex. "routine.name" which would get the specific routine
        documentReference.update("routines." + routineName, workoutTemplates);
    }
}
