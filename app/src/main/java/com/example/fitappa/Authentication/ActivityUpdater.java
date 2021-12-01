package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;

abstract class ActivityUpdater {
    protected OpensActivityWithProfile view;

    public ActivityUpdater(OpensActivityWithProfile view) {
        this.view = view;
    }

    void updateUI(Profile profile) {
        view.openActivityWith(profile);
    }

    void setError() {

    }
}
