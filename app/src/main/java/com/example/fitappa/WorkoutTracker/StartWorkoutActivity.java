package com.example.fitappa.WorkoutTracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Workout.Workout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class StartWorkoutActivity extends AppCompatActivity {
    List<Routine> routineList;
    // TODO: Remove this dependency
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Start Workout");
        this.profile = (Profile) getIntent().getSerializableExtra("profile");

        // Note: I will remove these when im done. Ignore for now.
        Routine r = new Routine("Your Second Routine", "");
        r.addWorkout(new Workout("Workout 1", ""));
        this.profile.addRoutine(r);

        this.routineList = profile.getRoutines();
        init(routineList);
    }


    /**
     * This method initializes the view with the user's routines and their respective workouts.
     * Thereby allowing the user to start a workout directly from this page.
     * @param routines represents the List of the user's routines.
     */
    private void init(List<Routine> routines) {
        LinearLayout routineContainer = findViewById(R.id.RoutinesContainer);

        for(Routine routine : routines) {
            addRoutineCard(routineContainer, routine);
        }
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

        for(Workout workout : routine.getWorkouts())
        {
            createWorkoutLayout(routineLayout, workout);
        }


        // Attach everything to routineContainer
        routineContainer.addView(routineCard);
    }


    /**
     * This method creates the Linear Layout (Workout) portion of the Routine Card.
     * @param routineLayout represents the view where the Linear Layout attaches to
     * @param workout represents the workout for which the Linear Layout is created for.
     */
    private void createWorkoutLayout(LinearLayout routineLayout, Workout workout) {
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
        workoutName.setText(workout.getName());
        workoutLayout.addView(workoutName);

        // Create the start workout button.
        Button startWorkoutBtn = new Button(this);
        startWorkoutBtn.setLayoutParams(defaultParams);
        startWorkoutBtn.setText(getString(R.string.StartWorkout));
        workoutLayout.addView(startWorkoutBtn);

        // Attach an onClickListener to the button
        startWorkoutBtn.setOnClickListener(v -> startWorkout(workout));
    }

    /**
     * Starts the given workout
     * @param workout represents the given workout
     */
    private void startWorkout(Workout workout) {
        //TODO: Finish this up when track workout is ready.
        Log.d("TAG", "The workout is ready to start");
    }



}
