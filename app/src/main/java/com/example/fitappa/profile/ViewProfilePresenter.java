package com.example.fitappa.profile;

/**
 * This activity class represents a users profile on the UI
 *
 * Methods in this class load information from the presenter and send information users input to the backend
 *
 * Documentation specifies what the methods do
 *
 * @author Souren
 * @author Uthman
 * @author Abdulah
 *
 * @since 0.6
 */

class ViewProfilePresenter implements LoadsProfile {
    private final View view;
    private Profile profile;

    ViewProfilePresenter(View view) {
        this.view = view;
        final String PAGE_TITLE = "profile";
        this.view.updateAppBarTitle(PAGE_TITLE);
        this.view.setupElements();

        Loadable gateway = new ProfileReader(this);
        gateway.load();
    }

    void saveSettings(String firstName, String lastName, String weight, String height) {
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setHeight(height);
        profile.setWeight(weight);

        Saveable gateway = new SaveProfileGateway();
        gateway.save(profile);
    }

    void logout() {
        view.signOut();
    }


    @Override
    public void loadProfile(Profile profile) {
        this.profile = profile;
        view.setup(profile.getUsername(), profile.getFirstName(), profile.getLastName(), profile.getWeight(), profile.getHeight());
    }

    interface View {
        void updateAppBarTitle(String title);

        void setup(String username, String firstName, String lastName, String weight, String height);

        void setupElements();

        void signOut();
    }
}