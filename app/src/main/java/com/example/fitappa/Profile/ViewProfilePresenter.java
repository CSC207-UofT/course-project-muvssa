package com.example.fitappa.Profile;

public class ViewProfilePresenter {
    private Profile profile;
    private View view;
    private String PAGE_TITLE = "Profile";

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
