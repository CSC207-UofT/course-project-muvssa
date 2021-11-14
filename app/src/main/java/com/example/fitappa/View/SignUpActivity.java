package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Profile;
import com.example.fitappa.Presenter.SignUpPresenter;
import com.example.fitappa.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;


public class SignUpActivity extends AppCompatActivity implements SignUpPresenter.View{
    private TextInputEditText user;
    private TextInputEditText pass;
    private TextInputEditText mail;
    private TextView enter;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        this.presenter = new SignUpPresenter(this);


        user = findViewById(R.id.userName);
        pass = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        enter = findViewById(R.id.submit);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signUpToProfile(user.getText().toString(),pass.getText().toString(),mail.getText().toString());
            }
        });


    }

    public void loggedIn(Profile profile){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("persons_Profile", (Serializable) profile);
        intent.putExtra("my_Profile", (Serializable) profile);
        startActivity(intent);

    }

}