package com.example.fitappa.Profile;

public class ViewProfilePresenter {
    private final View view;
    private final String PAGE_TITLE = "Profile";
    private Profile profile;

    public ViewProfilePresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle(PAGE_TITLE);
        loadProfile();
    }


    private void loadProfile() {
        // TODO @uthman
    }

    interface View {
        void updateAppBarTitle(String title);

    }
}