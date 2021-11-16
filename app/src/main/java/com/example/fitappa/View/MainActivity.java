package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signUpBtn = findViewById(R.id.SignUp);
        Button signInBtn = findViewById(R.id.SignIn);

        //Define and attach click listener
        signUpBtn.setOnClickListener(v -> openSignUpPage());

        signInBtn.setOnClickListener(v -> openLogInPage());
    }

    private void openSignUpPage() {
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(signUpIntent);
    }

    private void openLogInPage() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }
}