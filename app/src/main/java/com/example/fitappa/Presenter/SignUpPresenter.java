package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.SignUpInputBoundary;

public class SignUpPresenter {
    private final View view;
    private final SignUpInputBoundary signUpInputBoundary;

    /**
     * Constructor for creating the sign up section
     * @param signUpInputBoundary represents the user's input when signing up as type SignUpInputBoundary
     * @param view represents the view of the sign up section as type View
     */
    public SignUpPresenter(SignUpInputBoundary signUpInputBoundary, View view) {
        this.view = view;
        this.signUpInputBoundary = signUpInputBoundary;
    }

    /**
     * After the user signs up this opens the profile page
     * @param email String of the user's email
     * @param username String of the user's username
     * @param password String of the user's password
     */
    public void runSignUp(String email, String username, String password){
        Profile profile = signUpInputBoundary.signUp(email, username, password);

        if (profile != null) {
            view.openHome(profile);
        }
    }

    public interface View {
        void openHome(Profile profile);
    }

}
