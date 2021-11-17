package com.example.fitappa.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements OpensHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Get firebase user
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            // Check if a firebase authenticated user already exists (previously logged in)
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("users")
                    .document(firebaseUser.getUid())
                    .get()
                    .addOnSuccessListener(documentSnapshot -> {
                        Profile profile = documentSnapshot.toObject(Profile.class);
                        // Go to home page
                        openHome(profile);
                    });
            return;
        }


        setContentView(R.layout.activity_main);
        Button signUpBtn = findViewById(R.id.SignUp);
        Button loginBtn = findViewById(R.id.SignIn);

        //Define and attach click listener
        signUpBtn.setOnClickListener(v -> openSignUpPage());

        loginBtn.setOnClickListener(v -> openLogInPage());
    }

    private void openSignUpPage() {
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(signUpIntent);
    }

    private void openLogInPage() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

    @Override
    public void openHome(Profile profile) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("profile", profile);
        startActivity(intent);
    }
}