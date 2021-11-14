package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Profile;
import fitappfiles.Profiles;

public class SignUpPresenter {
    private View view;
    private Profiles profiles;

    public SignUpPresenter(View view) {
        this.view = view;
        this.profiles = new Profiles();
    }

    public void signUpToProfile(String name, String password, String email){
        System.out.println(name);
        System.out.println(password);
        System.out.println(email);
        profiles.signUp(name, password, email);
        System.out.println("her2");
        view.loggedIn(profiles.loginToProfile(name,password));

    }

    public interface View{
        void loggedIn(Profile profile);
    }

}
