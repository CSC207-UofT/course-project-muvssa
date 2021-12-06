package com.example.fitappa.Profile;

import java.io.Serializable;

public class DashboardPresenter {
    private final String PAGE_TITLE = "Dashboard";
    private final Profile profile;
    private View view;

    public DashboardPresenter(View view, Serializable profile) {

        this.profile = (Profile) profile;
        view.updateAppBarTitle(PAGE_TITLE);
        view.setupLogoutBtn(this.profile);
        view.setupWorkoutBtn(this.profile);
        view.setupProfileBtn(this.profile);
        view.setupLogBtn();
    }

    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);

        void setupLogoutBtn(Profile profile);

        void setupWorkoutBtn(Profile profile);

        void setupProfileBtn(Profile profile);

        void setupLogBtn();
    }
}
