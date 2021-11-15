package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.Profile;

public class LoginPresenter {
    private final LoginInputBoundary loginInputBoundary;
    private View view;

    public LoginPresenter(LoginInputBoundary loginInputBoundary, View view) {
        this.loginInputBoundary = loginInputBoundary;
        this.view = view;
    }

    public interface View {
        void openHome(Profile profile);
    }

    public void runLogin(String email, String password) {

        Profile profile = loginInputBoundary.login(email, password);
        view.openHome(profile);
    }
}
