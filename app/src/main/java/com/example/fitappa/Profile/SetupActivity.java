package com.example.fitappa.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappa.R;


/**
 * This class is a view class meant to open the activity_setup xml, and allow users to change information they previously
 * inputted
 *
 * The method in the class moves the information the user inputs to DashboardActivity
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Souren
 * @since 0.8
 */


public class SetupActivity extends AppCompatActivity implements SetupPresenter.View {
    private EditText weightText;
    private EditText heightText;
    private EditText firstNameText;
    private EditText lastNameText;
    private TextView errorInput;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Intent retrieveIntent = getIntent();

        SetupPresenter presenter = new SetupPresenter(this);

        errorInput = findViewById(R.id.wrong);
        errorInput.setVisibility(View.INVISIBLE);

        weightText = findViewById(R.id.weight);
        heightText = findViewById(R.id.height);
        firstNameText = findViewById(R.id.firstName);
        lastNameText = findViewById(R.id.lastName);
        Button enter = findViewById(R.id.submit);

        enter.setOnClickListener(v ->
                presenter.setUp( weightText, heightText, firstNameText, lastNameText)
        );
    }

    /**
     * Goes to the DashboardActivity
     */
    @Override
    public void goToDashboard() {
        finish();
        Intent home = new Intent(this, DashboardActivity.class);
        startActivity(home);
    }

    /**
     * Display an error message if the input doesn't meet format requirements
     */
    @Override
    public void setError() {
        errorInput.setVisibility(View.VISIBLE);
    }

}