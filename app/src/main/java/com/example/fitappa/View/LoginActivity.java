package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Presenter.LoginPresenter;
import com.example.fitappa.R;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {
    private LoginPresenter presenter;
    private EditText passwordField;
    private EditText emailField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordField = findViewById(R.id.PasswordField);
        emailField = findViewById(R.id.EmailField);
        TextView loginBtn = findViewById(R.id.LogInBtn);

        ReadWriter readWriter = new ProfileReadWriter();
        LoginInputBoundary loginInputBoundary = new LoginUseCase(readWriter);
        presenter = new LoginPresenter(loginInputBoundary, this);

        loginBtn.setOnClickListener(v ->
                presenter.runLogin(emailField.getText().toString(), passwordField.getText().toString()));
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