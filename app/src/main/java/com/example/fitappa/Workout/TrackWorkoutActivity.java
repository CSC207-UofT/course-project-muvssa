package com.example.fitappa.Workout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitappa.Exercise.Exercise.PerformExercise;
import com.example.fitappa.R;
import com.example.fitappa.Workout.Core.PerformWorkout;

import java.util.Objects;

/**
 *
 *
 * @layer 4
 */
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
        this.presenter = new TrackWorkoutPresenter(this, getIntent().getSerializableExtra(getString(R.string.WorkoutObject)));
    }


    /**
     *
     * @param title
     */
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
     * @param workout !!
     */
    public void populateLayout(PerformWorkout workout) {
        LinearLayout exerciseLayout = findViewById(R.id.ExerciseContainer);
        exerciseLayout.removeAllViews();

        for(PerformExercise<?> e : workout.getExercises()) {
            buildExerciseComponent(exerciseLayout, e);
        }
    }

    private void buildExerciseComponent(LinearLayout exerciseLayout, PerformExercise<?> e) {
        CardView cardView = new CardView(this);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        ((ViewGroup.MarginLayoutParams) cardView.getLayoutParams()).topMargin = 25;

        LinearLayout outerLayer = buildLinearLayout(LinearLayout.VERTICAL);
        outerLayer.setPadding(30,30,30,30);
        cardView.addView(outerLayer);
        outerLayer.addView(buildText(e.getName(), -1));

        LinearLayout exerciseBody = buildExerciseBody(e.getCategory());
        outerLayer.addView(exerciseBody);


        // Attach
        exerciseLayout.addView(cardView);

        // Set


        // Button
        Button addSetBtn = new Button(this);
        addSetBtn.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        ((ViewGroup.MarginLayoutParams) addSetBtn.getLayoutParams()).topMargin = 25;
        addSetBtn.setText(getString(R.string.AddSet));
        addSetBtn.setOnClickListener(v -> addSetToExercise(e.getCategory(), exerciseBody));
        outerLayer.addView(addSetBtn);


    }


    public LinearLayout buildExerciseBody(String s) {
        switch (s) {
            case "WEIGHTED":
                return buildWeightedExerciseBody();
            case "TIMED":
                return buildTimedExerciseBody();
            default:
                return buildRepExerciseBody();
        }
    }

    public void addSetToExercise(String category, LinearLayout exerciseBody) {
        switch (category) {
            case "WEIGHTED":
                addWeightedSetToExercise(exerciseBody);
            case "TIMED":
                addTimedSetToExercise(exerciseBody);
            default:
                addRepSetToExercise(exerciseBody);
        }
    }

    private void addTimedSetToExercise(LinearLayout exerciseBody) {
        // TODO:
        return;
    }

    private void addWeightedSetToExercise(LinearLayout exerciseBody) {
        // TODO:
        return;
    }

    private void addRepSetToExercise(LinearLayout exerciseBody) {
        LinearLayout setRow = buildLinearLayout(LinearLayout.HORIZONTAL);
        ((ViewGroup.MarginLayoutParams) setRow.getLayoutParams()).topMargin = 25;

        setRow.addView(buildText("1", 900/2));

        EditText rep = new EditText(this);
        rep.setWidth(900/2);
        setRow.addView(rep);

        exerciseBody.addView(setRow);
    }




    private LinearLayout buildRepExerciseBody() {

        LinearLayout exerciseBody = buildLinearLayout(LinearLayout.VERTICAL);
        LinearLayout titleRow = buildLinearLayout(LinearLayout.HORIZONTAL);
        exerciseBody.addView(titleRow);


        // Title Row
        ((ViewGroup.MarginLayoutParams) titleRow.getLayoutParams()).topMargin = 25;
        titleRow.addView(buildText("Set", 900/2));
        //titleRow.addView(buildText(getString(R.string.WeightUnit), 300));
        titleRow.addView(buildText("reps", 900/2));

        return exerciseBody;

    }

    private LinearLayout buildWeightedExerciseBody() {
        LinearLayout exerciseBody = buildLinearLayout(LinearLayout.VERTICAL);
        LinearLayout titleRow = buildLinearLayout(LinearLayout.HORIZONTAL);
        exerciseBody.addView(titleRow);
        // Title Row
        ((ViewGroup.MarginLayoutParams) titleRow.getLayoutParams()).topMargin = 25;
        titleRow.addView(buildText("Set", 900/3));
        titleRow.addView(buildText(getString(R.string.WeightUnit), 900/3));
        titleRow.addView(buildText("reps", 900/3));
        return exerciseBody;
    }

    private LinearLayout buildTimedExerciseBody() {
        // TODO:
        return null;
    }

    private LinearLayout buildLinearLayout(int orientation) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(orientation);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        return linearLayout;
    }

    /**
     * A set component is defined as:
     *
     *  LinearLayout (H)
     * 	    - TextView
     * 	    - EditText
     * 	    - EditText
     *
     * @return a set component
     */
    private LinearLayout buildSetComponent() {
        LinearLayout setComponent = new LinearLayout(this);
        setComponent.setOrientation(LinearLayout.HORIZONTAL);
        setComponent.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));

        setComponent.addView(buildText("1", 300));

        EditText weight = new EditText(this);
        weight.setWidth(300);
        setComponent.addView(weight);

        EditText reps = new EditText(this);
        reps.setWidth(300);
        setComponent.addView(reps);

        return setComponent;

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