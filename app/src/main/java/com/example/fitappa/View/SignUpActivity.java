package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.SignUpInputBoundary;
import com.example.fitappa.Model.UseCase.SignUpUseCase;
import com.example.fitappa.Presenter.SignUpPresenter;
import com.example.fitappa.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.Objects;


public class SignUpActivity extends AppCompatActivity implements SignUpPresenter.View {
    private TextInputEditText user;
    private TextInputEditText pass;
    private TextInputEditText mail;
    private TextView enter;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        user = findViewById(R.id.userName);
        pass = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        enter = findViewById(R.id.submit);

        String username = Objects.requireNonNull(user.getText()).toString();
        String password = Objects.requireNonNull(pass.getText()).toString();
        String email = mail.getText().toString();

        Log.d("Tag", "email is '" + email + "'");

        ReadWriter readWriter = new ProfileReadWriter();
        SignUpInputBoundary signUpInputBoundary = new SignUpUseCase(readWriter);
        this.presenter = new SignUpPresenter(signUpInputBoundary, this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tag", "TESTING EMAIL: '" + email + "'");
                presenter.runSignUp(email, username, password);
            }
        });


    }

    public void loggedIn(Profile profile) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("persons_Profile", (Serializable) profile);
        intent.putExtra("my_Profile", (Serializable) profile);
        startActivity(intent);

    }

}