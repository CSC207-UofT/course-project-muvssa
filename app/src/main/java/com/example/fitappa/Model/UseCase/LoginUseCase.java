package com.example.fitappa.Model.UseCase;

import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class LoginUseCase implements LoginInputBoundary {

    private Profile profile;
    ReadWriter readWriter;

    private FirebaseAuth mAuth;

    public enum LoginResult {
        SUCCESS, FAILURE
    }

    public LoginUseCase(Profile profile, ReadWriter readWriter) {
        this.profile = profile;
        this.readWriter = readWriter;
//        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public LoginResult login(String email, String password) {

//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser user = mAuth.getCurrentUser();
//                        } else {
//                            // If sign in fails, display a message to the user.
//                        }
//                    }
//                });

        return LoginResult.SUCCESS;
    }
}
