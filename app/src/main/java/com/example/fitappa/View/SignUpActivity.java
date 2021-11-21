package com.example.fitappa.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.Auth;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;

public class SignUpActivity extends AppCompatActivity implements Auth.View {
    private EditText usernameText;
    private EditText passwordText;
    private EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameText = findViewById(R.id.userName1);
        passwordText = findViewById(R.id.password);
        emailText = findViewById(R.id.email);
        Button enter = findViewById(R.id.submit);

        Auth auth = new Auth(this);

        enter.setOnClickListener(v -> auth.runSignUp(emailText, usernameText, passwordText));
    }

    @Override
    public void openHome(Profile profile) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("profile", profile);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}