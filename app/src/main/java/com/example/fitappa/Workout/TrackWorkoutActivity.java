package com.example.fitappa.Workout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitappa.Exercise.Exercise.ExerciseTemplate;
import com.example.fitappa.R;
import com.example.fitappa.Workout.Core.WorkoutTemplate;
import com.google.api.Distribution;

import java.util.Objects;


public class TrackWorkoutActivity extends AppCompatActivity implements TrackWorkoutPresenter.View {
    TrackWorkoutPresenter presenter;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_workout);
        this.presenter = new TrackWorkoutPresenter(this, (WorkoutTemplate) getIntent().getSerializableExtra(getString(R.string.WorkoutObject)));
    }


    public void updateAppBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);

    }

    /**
     * Update the title of this page with the workout name
     * @param workoutTitle -
     */
    public void updateTitle(String workoutTitle) {
        ((TextView) findViewById(R.id.WorkoutNameText)).setText(workoutTitle);
    }

    /**
     *
     * @param template !!
     */
    public void populateLayout(WorkoutTemplate template) {
        LinearLayout exerciseLayout = findViewById(R.id.ExerciseContainer);
        exerciseLayout.removeAllViews();

        for(ExerciseTemplate e : template.getExercises()) {
            buildExerciseComponent(exerciseLayout, e);
        }
    }

    private void buildExerciseComponent(LinearLayout exerciseLayout, ExerciseTemplate e) {
        CardView cardView = new CardView(this);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        ((ViewGroup.MarginLayoutParams) cardView.getLayoutParams()).topMargin = 25;


        LinearLayout outerLayer = new LinearLayout(this);
        outerLayer.setOrientation(LinearLayout.VERTICAL);
        outerLayer.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        outerLayer.setPadding(30,30,30,30);
        cardView.addView(outerLayer);

        outerLayer.addView(buildText(e.getName(), -1));

        // Title Row
        LinearLayout titleRow = new LinearLayout(this);
        titleRow.setOrientation(LinearLayout.HORIZONTAL);
        titleRow.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        outerLayer.addView(titleRow);

        ((ViewGroup.MarginLayoutParams) titleRow.getLayoutParams()).topMargin = 25;
        titleRow.addView(buildText("Set", 300));
        titleRow.addView(buildText(getString(R.string.WeightUnit), 300));
        titleRow.addView(buildText("reps", 300));
        // Attach
        exerciseLayout.addView(cardView);

        // Button
        Button addSetBtn = new Button(this);
        addSetBtn.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        ((ViewGroup.MarginLayoutParams) addSetBtn.getLayoutParams()).topMargin = 25;
        addSetBtn.setText("Add set");
        outerLayer.addView(addSetBtn);


    }



    private TextView buildText(String title, int width) {
       TextView t = new TextView(this);
       t.setText(title);
       t.setLayoutParams(new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT,
               ViewGroup.LayoutParams.WRAP_CONTENT, 1));

       if(width != -1) {
           t.setWidth(width);
       }

       return t;
    }


}