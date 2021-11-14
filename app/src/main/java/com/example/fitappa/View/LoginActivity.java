package com.example.fitappa.View;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Presenter.LoginPresenter;
import com.example.fitappa.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {
    private LoginPresenter presenter;
    private TextInputEditText passwordText;
    private TextInputEditText emailText;
    private TextView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);

        passwordText = findViewById(R.id.password);
        emailText = findViewById(R.id.email);
        enter = findViewById(R.id.submit);

        // Convert text to string
        String password = Objects.requireNonNull(passwordText.getText()).toString().trim();
        String email = Objects.requireNonNull(emailText.getText()).toString().trim();

        ReadWriter readWriter = new ProfileReadWriter();
        LoginInputBoundary loginInputBoundary = new LoginUseCase(readWriter);
        presenter = new LoginPresenter(loginInputBoundary, this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.runLogin(email, password);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}