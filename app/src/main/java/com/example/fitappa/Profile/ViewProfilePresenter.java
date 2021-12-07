package com.example.fitappa.Profile;

public class ViewProfilePresenter implements LoadsProfile {
    private final View view;
    private final String PAGE_TITLE = "Profile";
    private Profile profile;

    public ViewProfilePresenter(View view) {
        this.view = view;
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupElements();

        ProfileReader gateway = new ProfileReader(this);
        gateway.retrieveProfile();
    }

    public void saveSettings(String firstName, String lastName, String weight, String height) {
        profile.setExtraInfo(weight, height, firstName, lastName);

        Saveable gateway = new SaveProfileGateway();
        gateway.save(profile);
    }

    public void logout() {
        view.signOut();
    }


    @Override
    public void loadProfile(Profile profile) {
        this.profile = profile;
        view.setup(profile.getUsername(), profile.getFirstName(), profile.getLastName(), profile.getWeight(), profile.getHeight());
    }

    interface View {
        void updateAppBarTitle(String title);

        void setup(String username, String fname, String lname, String weight, String height);

        void setupElements();

        void signOut();
    }
}