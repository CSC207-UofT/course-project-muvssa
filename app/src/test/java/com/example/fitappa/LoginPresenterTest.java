package com.example.fitappa;

import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Presenter.LoginPresenter;
import junit.framework.TestCase;

public class LoginPresenterTest extends TestCase {

    LoginPresenter loginPresenter;

    public void setUp() throws Exception {
        super.setUp();
        Profile tempProfile = new Profile("Bob", "password", "email");
        ReadWriter profileReadWriter = new ProfileReadWriter();
        LoginInputBoundary loginUseCase = new LoginUseCase(tempProfile, profileReadWriter);
        this.loginPresenter = new LoginPresenter(loginUseCase);
    }

    public void testRunLogin() {
        String email = "test@test.com";
        String password = "password123";
        assertTrue(this.loginPresenter.runLogin(email, password));
    }
}