package com.example.fitappa.Profile;

public class ViewProfilePresenter {
    private final View view;
    private final String PAGE_TITLE = "Profile";
    private Profile profile;

    public ViewProfilePresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupElements();

        loadProfile();

        // TODO @uthman call this.setup() once profile is loaded

    }

    public void saveSettings() {
        // TODO @UTHMAN, save the settings here
        // The view calls this method when save button is pressed
    }

    public void logout() {
        // TODO @uthman
    }


    private void loadProfile() {
        // TODO @uthman - uppdate: not sure if u need to do this
    }

    interface View {
        void updateAppBarTitle(String title);
        void setup(String username, String fname, String lname, String weight, String height);
        void setupElements();
    }
}