package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;

public class LoginPresenter {
    private final LoginInputBoundary loginInputBoundary;

    public LoginPresenter(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    public boolean runLogin(String username, String password) {
        LoginUseCase.LoginResult result = loginInputBoundary.login(username, password);
        switch (result) {
            case SUCCESS:
                return true;
            case FAILURE:
                return false;
        }
        return false;
    }
}
