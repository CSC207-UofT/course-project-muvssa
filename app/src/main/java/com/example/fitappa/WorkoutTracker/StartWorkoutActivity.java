package com.example.fitappa.WorkoutTracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;
import com.example.fitappa.Routine.Routine;
import com.example.fitappa.Workout.Workout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class StartWorkoutActivity extends AppCompatActivity {
    List<Routine> routineList;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Start Workout");
        this.profile = (Profile) getIntent().getSerializableExtra("profile");
        Routine r = new Routine("Your Second Routine", "");
        r.addWorkout(new Workout("Workout 1", ""));
        this.profile.addRoutine(r);

        this.routineList = profile.getRoutines();
        init(routineList);
    }

    private void init(List<Routine> routines) {
        LinearLayout routineContainer = findViewById(R.id.RoutinesContainer);

        for(Routine routine : routines) {
            /**
             * Format of a routine card:
             * CardView
             *      + LinearLayout
             *          _ LinearLayout
             *              + TextView (Routine Name)
             *              + Button (Minimize Routine)
             *          + LinearLayout (One per workout)
             *              + TextView (Workout Name)
             *              + Button (Start Workout)
             *
             */

            CardView routineCard = new CardView(new ContextThemeWrapper(this, R.style.routinesCardStyle), null, 0);
            routineCard.setContentPadding(45,45,45,45);

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
                noWorkouts.setText("No workouts in this routine");
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




    }

    private void createWorkoutLayout(LinearLayout routineLayout, Workout workout) {
        LinearLayout.LayoutParams defaultParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1);


        LinearLayout workoutLayout = new LinearLayout(this);
        workoutLayout.setLayoutParams(defaultParams);
        workoutLayout.setOrientation(LinearLayout.HORIZONTAL);
        routineLayout.addView(workoutLayout);

        TextView workoutName = new TextView(this);
        workoutName.setLayoutParams(defaultParams);
        workoutName.setText(workout.getName());
        workoutLayout.addView(workoutName);

        Button startWorkoutBtn = new Button(this);
        startWorkoutBtn.setLayoutParams(defaultParams);
        startWorkoutBtn.setText("START");
        workoutLayout.addView(startWorkoutBtn);
    }


}
