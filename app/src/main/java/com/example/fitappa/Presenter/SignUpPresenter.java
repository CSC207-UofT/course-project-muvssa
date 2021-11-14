package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.SignUpInputBoundary;
import fitappfiles.Profiles;

public class SignUpPresenter {
    private View view;
    private SignUpInputBoundary signUpInputBoundary;

    public SignUpPresenter(SignUpInputBoundary signUpInputBoundary, View view) {
        this.view = view;
        this.signUpInputBoundary = signUpInputBoundary;
    }

    public void runSignUp(String email, String username, String password){
//        view.loggedIn(profiles.loginToProfile(name,password));

//        signUpInputBoundary.signUp();
//        view.loggedIn(signUpInputBoundary);
        Profile profile = signUpInputBoundary.signUp(email, username, password);

        System.out.println("Testtt");
        if (profile != null) {
            view.loggedIn(profile);
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    public interface View {
        void loggedIn(Profile profile);
    }

}
