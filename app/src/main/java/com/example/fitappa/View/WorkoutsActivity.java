package com.example.fitappa.View;

import android.content.Intent;
import android.widget.TableLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.Routine;
import com.example.fitappa.Presenter.WorkoutsActivityPresenter;
import com.example.fitappa.R;
import com.example.fitappa.Model.Profile;

import java.util.ArrayList;

public class WorkoutsActivity extends AppCompatActivity implements WorkoutsActivityPresenter.View {
    private Intent retrieveIntent;
    private Profile profile;
    private WorkoutsActivityPresenter presenter;
    private TableLayout routinesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default Android Stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts2);

        // Get the profile
        this.profile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");

        // We must initialize the Presenter in the View.
        this.presenter = new WorkoutsActivityPresenter(this, profile);

    }


    @Override
    public void updateRoutinesView(ArrayList<Routine> routines) {
        
    }
}