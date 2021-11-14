package com.example.fitappa.Model.UseCase;


import androidx.annotation.NonNull;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginUseCase implements LoginInputBoundary {

    ReadWriter readWriter;

    public enum LoginResult {
        SUCCESS, FAILURE
    }

    public LoginUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    @Override
    public Profile login(String email, String password) {



        return null;
    }
}
