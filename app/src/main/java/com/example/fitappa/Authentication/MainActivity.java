package com.example.fitappa.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Profile.DashboardActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements OpensActivityWithProfile {

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();

        checkAuth();
        setContentView(R.layout.activity_main);

        Button signUpBtn = findViewById(R.id.SignUp);
        Button loginBtn = findViewById(R.id.SignIn);

        //Define and attach click listener
        signUpBtn.setOnClickListener(v -> openSignUpPage());

        loginBtn.setOnClickListener(v -> openLogInPage());
    }

    /**
     * This method checks if the user was already logged in. If they are already logged, go to DashboardActivity,
     * if not, continue.
     */
    private void checkAuth() {
        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            // Check if a firebase authenticated user already exists (previously logged in)
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("users")
                    .document(firebaseUser.getUid())
                    .get()
                    .addOnSuccessListener(documentSnapshot -> {
                        ProcessFirebase processFirebase = new ProcessFirebase(this);
                        processFirebase.updateViewWithProfileFrom(documentSnapshot);
                    });
        }
    }

    /**
     * This method opens the SignUpActivity View
     */
    private void openSignUpPage() {
        Intent signUp = new Intent(this, SignUpActivity.class);
        startActivity(signUp);
    }

    /**
     * This method opens the LoginActivity View
     */
    private void openLogInPage() {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    /**
     * This method opens the DashboardActivity View and passes in a Profile
     */
    @Override
    public void openActivityWith(Profile profile) {
        Intent home = new Intent(this, DashboardActivity.class);
        home.putExtra("profile", profile);
        startActivity(home);
    }
}