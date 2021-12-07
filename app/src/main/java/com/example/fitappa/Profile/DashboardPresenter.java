package com.example.fitappa.Profile;

/**
 * This class is a presenter for the Dashboard activity
 *
 * Methods in this set up buttons and the title of the activity
 *
 * Documentation specifies what the methods do
 *
 * @author Uthman
 *
 * @since 0.6
 */

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
