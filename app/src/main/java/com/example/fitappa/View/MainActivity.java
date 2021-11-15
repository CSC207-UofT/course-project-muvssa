package com.example.fitappa.View;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;

public class MainActivity extends AppCompatActivity {
    private Button SignInBtn;
    private Button SignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.SignUpBtn = findViewById(R.id.SignUp);
        this.SignInBtn = findViewById(R.id.SignIn);

        //Define and attach click listener
        this.SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });

        this.SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInPage();
            }
        });
    }

    private void openSignUpPage() {
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(signUpIntent);
    }

    private void openLogInPage() {
        Intent loginIntent = new Intent(this, ProfileActivity.class);
        startActivity(loginIntent);
    }
}