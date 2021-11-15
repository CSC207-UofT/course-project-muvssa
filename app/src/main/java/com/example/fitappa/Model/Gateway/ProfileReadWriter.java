package com.example.fitappa.Model.Gateway;

import android.util.Log;
import androidx.annotation.NonNull;
import com.example.fitappa.Model.Entity.User;
import com.example.fitappa.Model.UseCase.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Objects;

public class ProfileReadWriter implements ReadWriter {

    FirebaseFirestore db;
    Profile newProfile;

    public ProfileReadWriter() {
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void save(Object o) {
//        db.collection("users").add(o);
    }

    @Override
    public Profile read(String email, String password) {
//        db.collection("users")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
//                                HashMap<String, Object> profile = (HashMap<String, Object>) document.getData();
//                                HashMap<String, String> user = (HashMap<String, String>) profile.get("user");
//                                if (user.get("email").equals(email) && user.get("password").equals(password)) {
//
//                                }
////                                Log.d("Testing1", user.get("email"));
////                                Log.d("Testing1", user.get("password"));
////                                Log.d("Testing1", user.get("username"));
////                                Log.d("testing1", profile.toString());
//                            }
//                        }
//                    }
//                });
//        return newProfile;
        return null;
    }
}
