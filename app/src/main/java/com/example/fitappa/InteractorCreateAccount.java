package com.example.fitappa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import fitappfiles.Profile;
import fitappfiles.Profiles;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;


public class InteractorCreateAccount extends AppCompatActivity {
    private TextInputEditText user;
    private TextInputEditText pass;
    private TextInputEditText mail;
    private TextView enter;
    private Profiles profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        this.profiles = new Profiles();


        user = findViewById(R.id.userName);
        pass = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        enter = findViewById(R.id.submit);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createA(user.getText().toString(),pass.getText().toString(),mail.getText().toString());
            }
        });

    }

    private void createA(String username, String password, String email) {
        System.out.println(this.profiles.signUp(username,password,email));

        Intent intent = new Intent(this, InteractorProfile.class);
        intent.putExtra("persons_Profile", (Serializable) profiles.loginToProfile(username,password));
        intent.putExtra("my_Profile", (Serializable) profiles.loginToProfile(username,password));
        startActivity(intent);
    }

}