package com.example.fitappa.Workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.Profile.DashboardActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Workout.CRUD.AddRoutineActivity;
import com.example.fitappa.Workout.CRUD.AddWorkoutActivity;
import com.example.fitappa.Workout.CRUD.ViewWorkoutActivity;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.util.List;
import java.util.Objects;

/**
 * This Class represents the Start Workout Page
 * The purpose of this page is to
 *      1. allow the user to start tracking their workout
 *      2. Make changes to their routines and workout templates
 *
 * @author abdullah
 * @version 0.1
 */
public class StartWorkoutActivity extends AppCompatActivity implements StartWorkoutPresenter.View {
    private List<Routine> routineList;
    private StartWorkoutPresenter presenter;
    // TODO: Remove this dependency
    private Profile profile;
    LinearLayout.LayoutParams params;

    // TODO: Clean this mess
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Start Workout");
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        // dummy data
        Routine r = new Routine("MMA routine");
        WorkoutTemplate w = new WorkoutTemplate("High Intensity");
        ExerciseTemplate e1 = new ExerciseTemplate("Go crazy (Rep)", 0, "REP");
        ExerciseTemplate e2 = new ExerciseTemplate("Go wild (Weight)", 0, "WEIGHTED");
        w.addExercise(e1);
        w.addExercise(e2);
        r.addWorkout(w);
        this.profile.addRoutine(r);


        this.presenter = new StartWorkoutPresenter(this, profile);

        Button createRoutineBtn = findViewById(R.id.createRoutineBtn);
        this.routineList = profile.getRoutines();

        this.params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1);


        createRoutineBtn.setOnClickListener(v -> openAddRoutine());
        init(routineList);
    }

    /**
     * Activates when Android back button is pressed. Go back to dashboard and pass along the
     * current profile object as well.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backToDashboard();
    }

    private void backToDashboard() {
        Intent dashboard = new Intent(this, DashboardActivity.class);
        dashboard.putExtra("profile", profile);
        startActivity(dashboard);
    }

    /**
     * This method initializes the view with the user's routines and their respective workouts.
     * Thereby allowing the user to start a workout directly from this page.
     *
     * @param routines represents the List of the user's routines.
     */
    public void init(List<Routine> routines) {
        LinearLayout routineContainer = findViewById(R.id.RoutinesContainer);
        routineContainer.removeAllViews();

        for(Routine routine : routines) {
            addRoutineCard(routineContainer, routine);
        }
    }

    // TODO: javadoc
    public void updateRoutinesView(Routine routine) {
        LinearLayout routineContainer = findViewById(R.id.RoutinesContainer);
        addRoutineCard(routineContainer, routine);
    }



    /**
     * A Routine Card is a View Component that has the following form:
     * CardView
     *  + LinearLayout (Vertical)
     *      + LinearLayout (Horizontal)
     *          + TextView (Routine Name)
     *          + Button (Minimize Routine)
     *      + LinearLayout (One per workout)
     *          + TextView (Workout Name)
     *          + Button (Start Workout)
     *
     * This method creates a routine card and adds it to routineContainer for each
     * the given routine.
     * @param routineContainer represents the view that will hold the routine card.
     * @param routine represents the routine that the routine card will be created for.
     */
    private void addRoutineCard(LinearLayout routineContainer, Routine routine) {
        CardView routineCard = new CardView(this);
        routineCard.setContentPadding(45,45,45,45);

        // This is important to do in order to set margins
        routineCard.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) routineCard.getLayoutParams();

        layoutParams.setMargins(0, 40, 0, 0);

        LinearLayout routineLayout = new LinearLayout(this);
        routineLayout.setOrientation(LinearLayout.VERTICAL);
        routineCard.addView(routineLayout);

        // Routine Name
        TextView routineName = new TextView(this);
        routineName.setText(routine.getName());
        routineLayout.addView(routineName);

        // Linear Layout Per Workout
        if(routine.getWorkouts().size() == 0) {
            TextView noWorkouts = new TextView(this);
            noWorkouts.setText(getString(R.string.NoWorkoutInRoutine));
            noWorkouts.setPadding(0, 50, 0, 0);
            routineLayout.addView(noWorkouts);
        }

        for(WorkoutTemplate workoutTemplate : routine.getWorkouts())
        {
            createWorkoutLayout(routineLayout, workoutTemplate);
        }

        // Add a button to add workout
        Button addWorkoutBtn = new Button(this);
        addWorkoutBtn.setLayoutParams(this.params);
        ((ViewGroup.MarginLayoutParams) addWorkoutBtn.getLayoutParams()).topMargin = 40;
        addWorkoutBtn.setText(getString(R.string.AddWorkout));
        addWorkoutBtn.setOnClickListener(v -> openAddWorkout(routine));
        routineLayout.addView(addWorkoutBtn);


        // Attach everything to routineContainer
        routineContainer.addView(routineCard);
    }


    /**
     * This method creates the Linear Layout (Workout) portion of the Routine Card.
     * @param routineLayout represents the view where the Linear Layout attaches to
     * @param workoutTemplate represents the workout for which the Linear Layout is created for.
     */
    private void createWorkoutLayout(LinearLayout routineLayout, WorkoutTemplate workoutTemplate) {
        // Default Params
        LinearLayout.LayoutParams defaultParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1);

        // Create the workoutLayout
        LinearLayout workoutLayout = new LinearLayout(this);
        workoutLayout.setLayoutParams(defaultParams);
        workoutLayout.setOrientation(LinearLayout.HORIZONTAL);
        routineLayout.addView(workoutLayout);

        // Create the WorkoutName Text
        TextView workoutName = new TextView(this);
        workoutName.setLayoutParams(defaultParams);
        workoutName.setText(workoutTemplate.getName());
        workoutName.setPadding(0, 40, 0, 0);
        workoutLayout.addView(workoutName);

        // Create Inner Layout
        LinearLayout innerLayout = new LinearLayout(this);
        workoutLayout.setLayoutParams(defaultParams);
        workoutLayout.setOrientation(LinearLayout.HORIZONTAL);
        workoutLayout.addView(innerLayout);

        // Create the start workout button.
        Button startWorkoutBtn = new Button(this);
        startWorkoutBtn.setLayoutParams(defaultParams);
        startWorkoutBtn.setText(getString(R.string.StartWorkout));
        innerLayout.addView(startWorkoutBtn);


        // Create the edit workout button
        Button editWorkoutBtn = new Button(this);
        editWorkoutBtn.setLayoutParams(defaultParams);
        editWorkoutBtn.setText(getString(R.string.EditWorkout));
        editWorkoutBtn.setOnClickListener(v -> openEditWorkout(workoutTemplate));
        innerLayout.addView(editWorkoutBtn);


        // Attach an onClickListener to the button
        startWorkoutBtn.setOnClickListener(v -> startWorkout(workoutTemplate));

    }

    /**
     * opens edit workout activity
     * @param workoutTemplate represents a workout template
     */
    private void openEditWorkout(WorkoutTemplate workoutTemplate) {
        Intent editWorkout = new Intent(this, ViewWorkoutActivity.class);
        editWorkout.putExtra(getString(R.string.WorkoutObject), workoutTemplate);
        startActivity(editWorkout);
    }

    /**
     * Starts the given workout
     * @param workoutTemplate represents the given workout
     */
    private void startWorkout(WorkoutTemplate workoutTemplate) {
        Intent trackWorkout = new Intent(this, TrackWorkoutActivity.class);
        trackWorkout.putExtra(getString(R.string.WorkoutObject), workoutTemplate);
        startActivity(trackWorkout);
    }

    /**
     * This method opens the AddRoutineActivity View
     */
    private void openAddRoutine() {
        Intent createRoutinesIntent = new Intent(this, AddRoutineActivity.class);
        startActivityForResult(createRoutinesIntent, 1);
    }

    /**
     * This method retrieves data from AddRoutineActivity view.
     *
     * @param requestCode represents the integer identification for the data
     * @param resultCode  represents the result of the retrieve
     * @param data        represents the data that is retrieved
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            presenter.addRoutine(data.getStringExtra("routineName"));
        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            presenter.addWorkoutToRoutine(data.getStringExtra("workoutName"));
        }

    }

    /**
     * Opens the AddWorkoutActivity view
     */
    private void openAddWorkout(Routine r) {
        Intent addWorkout = new Intent(this, AddWorkoutActivity.class);
        this.presenter.setCurrentRoutine(r);
        startActivityForResult(addWorkout, 2);
    }

}
