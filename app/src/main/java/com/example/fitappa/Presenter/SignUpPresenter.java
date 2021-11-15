package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.SignUpInputBoundary;

public class SignUpPresenter {
    private final View view;
    private final SignUpInputBoundary signUpInputBoundary;

    public SignUpPresenter(SignUpInputBoundary signUpInputBoundary, View view) {
        this.view = view;
        this.signUpInputBoundary = signUpInputBoundary;
    }

    public void runSignUp(String email, String username, String password){
        Profile profile = signUpInputBoundary.signUp(email, username, password);

        if (profile != null) {
            view.loggedIn(profile);
        }
    }

    public interface View {
        void loggedIn(Profile profile);
    }

}
