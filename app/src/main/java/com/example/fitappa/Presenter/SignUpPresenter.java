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

    public void signUp(String name, String password, String email){
        this.profiles.signUp(name,password,email);
        view.loggedIn(profiles.loginToProfile(name,password));
    }

    public interface View{
        void loggedIn(Profile profile);
    }


    public interface view {
    }
}
