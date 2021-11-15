package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.SignUpInputBoundary;
import com.example.fitappa.Model.UseCase.SignUpUseCase;
import com.example.fitappa.Presenter.SignUpPresenter;
import com.example.fitappa.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;
import java.util.regex.Pattern;


public class SignUpActivity extends AppCompatActivity implements SignUpPresenter.View {
    private EditText user;
    private EditText pass;
    private EditText mail;
    private Button enter;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        user = findViewById(R.id.userName1);
        pass = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        enter = findViewById(R.id.submit);

        ReadWriter readWriter = new ProfileReadWriter();
        SignUpInputBoundary signUpInputBoundary = new SignUpUseCase(readWriter);
        this.presenter = new SignUpPresenter(signUpInputBoundary, this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verifyCredentials(
                        Objects.requireNonNull(mail.getText()).toString(),
                        Objects.requireNonNull(user.getText()).toString(),
                        Objects.requireNonNull(pass.getText()).toString()))
                {
                    // only run signup if credentials are verified
                    presenter.runSignUp(
                            Objects.requireNonNull(mail.getText()).toString(),
                            Objects.requireNonNull(user.getText()).toString(),
                            Objects.requireNonNull(pass.getText()).toString());
                }
            }
        });


    }

    public void loggedIn(Profile profile) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("persons_Profile", profile);
        intent.putExtra("profile", profile);
        startActivity(intent);
    }

    /**
     * Make sure email, username, and password are valid entries
     * @param email
     * @param username
     * @param password
     * @return true iff credentials are valid
     */
    private boolean verifyCredentials(String email, String username, String password) {

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pat = Pattern.compile(emailRegex);

        if (username.isEmpty()) {
            user.setError("Please fill out username");
            user.requestFocus();
            return false;
        } else if (username.length() < 5) {
            user.setError("Please make your username at least 5 characters long");
            user.requestFocus();
            return false;
        } else if (password.isEmpty()) {
            pass.setError("Please fill out password");
            pass.requestFocus();
            return false;
        } else if (password.length() < 6) {
            pass.setError("Please make your password at least 6 characters long");
            pass.requestFocus();
            return false;
        } else if (email.isEmpty()) {
            mail.setError("Please fill out email");
            mail.requestFocus();
            return false;
        } else if (!pat.matcher(email).matches()) {
            mail.setError("Please enter a proper email address");
            mail.requestFocus();
            return false;
        }
        return true;
    }

}