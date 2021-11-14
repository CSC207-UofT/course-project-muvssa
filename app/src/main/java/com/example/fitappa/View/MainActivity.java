package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private Button SignIn;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Database, I think we just need to do it once here.
        Realm.init(this);

        SignUp = findViewById(R.id.SignUp);
        SignIn = findViewById(R.id.SignIn);

        //Define and attach click listener
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createA();
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });
    }

    private void createA() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void logIn() {
        Intent intent = new Intent(this, ProfileActivity.class);

        startActivity(intent);
    }
}