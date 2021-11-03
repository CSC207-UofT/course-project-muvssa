package com.example.fitappa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Interactor extends AppCompatActivity {
    private TextView messageCreate;
    private TextView messageLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageCreate = findViewById(R.id.createATitle);
        messageLog = findViewById(R.id.logIn);

        //Define and attach click listener
        messageCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createA();
            }
        });

        messageLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });
    }

    private void createA() {
        Intent intent = new Intent(this, InteractorCreateAccount.class);
        startActivity(intent);
    }

    private void logIn() {
        Intent intent = new Intent(this, InteractorProfile.class);

        startActivity(intent);
    }
}