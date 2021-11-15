package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter {
    private final LoginInputBoundary loginInputBoundary;
    private View view;

    public LoginPresenter(LoginInputBoundary loginInputBoundary, View view) {
        this.loginInputBoundary = loginInputBoundary;
        this.view = view;
    }

    public interface View {
        void loggedIn(Profile profile);
    }

    public void runLogin(String email, String password) {




        view.loggedIn(loginInputBoundary.login(email, password));
    }
}
