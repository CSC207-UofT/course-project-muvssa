package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;

abstract class AuthenticationPresenter {
    protected OpensActivityWithProfile view;

    AuthenticationPresenter(OpensActivityWithProfile view) {
        this.view = view;
    }

    void updateUI(Profile profile) {
        view.openActivityWith(profile);
    }

    void setError() {

    }
}
