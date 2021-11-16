package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.Profile;

public class LoginPresenter {
    private final LoginInputBoundary loginInputBoundary;
    private View view;

    /**
     * Update the login view
     * @param loginInputBoundary String of the input from the login
     * @param view type view which represents the login
     */
    public LoginPresenter(LoginInputBoundary loginInputBoundary, View view) {
        this.loginInputBoundary = loginInputBoundary;
        this.view = view;
    }

    public interface View {
        void openHome(Profile profile);
    }

    /**
     * Creates profile and opens the profile screen
     * @param email string which represents the email of the user
     * @param password string which represents the password of the user
     */
    public void runLogin(String email, String password) {

        Profile profile = loginInputBoundary.login(email, password);
        view.openHome(profile);
    }
}
