package com.example.fitappa.Profile;

class ProfilePresenter implements UpdatesViewProfile {
    private final Profile currentProfile;
    private final Profile profile;
    private final View view;

    /**
     * Constructor for ProfilePresenter class
     *
     * @param view        type view that represents the profile
     * @param myProfile   type Profile that represents the user's profile
     * @param thisProfile type Profile that represents another profile
     */
    public ProfilePresenter(View view, Profile myProfile, Profile thisProfile) {
        this.view = view;
        this.profile = myProfile;
        this.currentProfile = thisProfile;
    }

    /**
     * Determines if a profile belongs to the user
     *
     * @return returns a boolean value of whether the username of a user is the same as the current user's username
     */
    boolean isMyProfile() {
        return profile.retrieveUsername().equals(currentProfile.retrieveUsername());
    }

    /**
     * Gets the username from the user's profile
     *
     * @return the username of a user as type Profile
     */
    String getUsername() {
        return currentProfile.retrieveUsername();
    }

    /**
     * Gets the amount of people that are following the user
     *
     * @return the number of people that are following the user as type Profile
     */
    String getFollow() {
        return String.valueOf(currentProfile.getFollowManager().followerCount());
    }

    /**
     * Gets the amount of people that the user is following
     *
     * @return the number of people that the user is following as type Profile
     */
    String getFollowing() {
        return String.valueOf(currentProfile.getFollowManager().followingCount());
    }

    /**
     * Search for a profile inside the database that matches the given username
     *
     * @param username String username to be searched for
     */
    void searchForProfileWithUsername(String username) {
        if (username.equals(profile.retrieveUsername())) {
            view.profileNotFound();
        } else {
            ProfileReader gateway = new ProfileReader(this);
            gateway.retrieveProfile(username);
        }
    }

    /**
     * If a non-empty profile was passed in, then a profile was successfully found,
     * so open the view profile page for it.
     * If the profile passed in was null, then the profile wasn't found,
     * so update UI accordingly
     *
     * @param profile Profile that represents the profile found from the search, or null if the profile wasn't found
     */
    @Override
    public void updateViewProfileWith(Profile profile) {
        if (profile != null) {
            view.openProfileFor(profile);
        } else {
            view.profileNotFound();
        }
    }


    interface View {
        /**
         * Open profile page to view for a profile that was searched for
         *
         * @param searchedProfile Profile that was searched for
         */
        void openProfileFor(Profile searchedProfile);

        /**
         * This method executes when the program cannot find the user that was searched for from the database
         */
        void profileNotFound();

        /**
         * When the user goes back from viewing a searched profile, update the view profile activity to show
         * current profile's information
         */
        void backToCurrentProfilesViewProfile();

    }

}
