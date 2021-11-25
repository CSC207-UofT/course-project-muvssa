package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.Gateway.FirebaseGateway;
import com.example.fitappa.Model.Gateway.Saveable;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkAuth();
        setContentView(R.layout.activity_main);

        Button signUpBtn = findViewById(R.id.SignUp);
        Button loginBtn = findViewById(R.id.SignIn);

        //Define and attach click listener
        signUpBtn.setOnClickListener(v -> openSignUpPage());

        loginBtn.setOnClickListener(v -> openLogInPage());
    }

    /**
     * This method checks if the user was already logged in. If so, continue.
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
                        // TODO: Similar code to Auth.login()
                        Profile profile = documentSnapshot.toObject(Profile.class);

                        // if profile isn't null, add a gateway to it
                        if (profile != null) {
                            Saveable gateway = new FirebaseGateway();
                            profile.setGateway(gateway);
                        }

                        // Pass new profile into the view
                        openHome(profile);
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
     * This method opens the HomeActivity View
     */
    private void openHome(Profile profile) {
        Intent home = new Intent(this, DashboardActivity.class);
        home.putExtra("profile", profile);
        startActivity(home);
    }
}