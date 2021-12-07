package com.example.fitappa.Profile;

class DashboardPresenter {

    DashboardPresenter(View view) {

        // Set app bar title
        final String PAGE_TITLE = "Dashboard";
        view.updateAppBarTitle(PAGE_TITLE);

        // Setup buttons
        view.setupButtons();
    }

    /**
     * This is the view that this presenter will control
     */
    interface View {
        void updateAppBarTitle(String title);

        void setupButtons();
    }
}
