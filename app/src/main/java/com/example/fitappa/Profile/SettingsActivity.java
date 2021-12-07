package com.example.fitappa.Profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;


/**
 * This class is a view class meant to open the activity_setting xml
 * <p>
 * The method in the class updated a users extra information
 * <p>
 * The documentation specifies what each method does
 *
 * @author Souren
 * @since 1.1
 */


public class SettingsActivity extends AppCompatActivity implements SettingsPresenter.View {
    private TextView weightText;
    private EditText weightInput;
    private TextView heightText;
    private EditText heightInput;
    private TextView firstText;
    private EditText firstInput;
    private TextView lastText;
    private EditText lastInput;
    private Profile myProfile;
    private SettingsPresenter presenter;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent retrieveIntent = getIntent();
        this.myProfile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");
        presenter = new SettingsPresenter(this, myProfile);

        weightText = findViewById(R.id.weightSetting);
        weightInput = findViewById(R.id.weightChangeInput);
        weightText.setText("Your weight is: " + presenter.getSettingWeight());

        heightText = findViewById(R.id.heightSetting);
        heightInput = findViewById(R.id.heightChangeInput);
        heightText.setText("Your height is: " + presenter.getSettingHeight());

        firstText = findViewById(R.id.firstNameSetting);
        firstInput = findViewById(R.id.firstChangeInput);
        firstText.setText("Your first name is: " + presenter.getSettingFirstName());

        lastText = findViewById(R.id.lastNameSetting);
        lastInput = findViewById(R.id.lastChangeInput);
        lastText.setText("Your last name is: " + presenter.getSettingLastName());

        TextView submit = findViewById(R.id.submitSettings);
        submit.setOnClickListener(v -> presenter.changeSettings(weightInput,
                heightInput, firstInput, lastInput));

    }

    /**
     * Activate when Android back button is pressed. Return to ProfileActivity.
     */
    @Override
    public void onBackPressed() {
        toProfile();
        super.onBackPressed();
    }

    /**
     * Display the changes the user made to their settings
     */
    @Override
    public void update() {
        weightText.setText(String.format("Your weight is: %s", presenter.getSettingWeight()));
        heightText.setText(String.format("Your height is: %s", presenter.getSettingHeight()));
        firstText.setText(String.format("Your first name is: %s", presenter.getSettingFirstName()));
        lastText.setText(String.format("Your last name is: %s", presenter.getSettingLastName()));
    }


    /**
     * return to profile after changes made
     */
    private void toProfile() {
        Intent home = new Intent(this, ViewProfileActivity.class);
        home.putExtra("my_Profile", myProfile);
        home.putExtra("persons_Profile", myProfile);
        startActivity(home);

    }
}