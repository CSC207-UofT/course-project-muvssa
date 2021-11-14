package com.example.fitappa.View;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.R;
import com.example.fitappa.Model.Profile;

public class WorkoutsActivity extends AppCompatActivity {
    private Intent retrieveIntent;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts2);

        this.profile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");

    }
}