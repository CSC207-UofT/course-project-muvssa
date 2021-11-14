package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private TextView messageCreate;
    private TextView messageLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Database, I think we just need to do it once here.
        Realm.init(this);

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
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void logIn() {
        Intent intent = new Intent(this, ProfileActivity.class);

        startActivity(intent);
    }
}