package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.Auth;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements GoesHome {
    private EditText passwordField;
    private EditText emailField;
    private Auth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        this.auth = new Auth(mAuth, this);

        passwordField = findViewById(R.id.PasswordField);
        emailField = findViewById(R.id.EmailField);
        TextView loginBtn = findViewById(R.id.LogInBtn);

        loginBtn.setOnClickListener(v ->
                auth.login(emailField.getText().toString(), passwordField.getText().toString())
        );
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void openHome(Profile profile) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("profile", profile);
        startActivity(intent);
    }
}