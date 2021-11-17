package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.Auth;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class SignUpActivity extends AppCompatActivity implements GoesHome {
    private EditText user;
    private EditText pass;
    private EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        user = findViewById(R.id.userName1);
        pass = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        Button enter = findViewById(R.id.submit);

        Auth auth = new Auth(mAuth, this);

        enter.setOnClickListener(v -> {
            if (auth.verifyCredentials(mail, user, pass))
            {
                auth.signUp(
                        Objects.requireNonNull(mail.getText()).toString(),
                        Objects.requireNonNull(user.getText()).toString(),
                        Objects.requireNonNull(pass.getText()).toString());
            }
        });


    }

    public void openHome(Profile profile) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("profile", profile);
        startActivity(intent);
    }
}