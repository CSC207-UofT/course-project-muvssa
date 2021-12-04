package com.example.fitappa.Profile;

import java.util.regex.Pattern;

/**
 * This class is a presenter class for ViewSetupActivity
 * <p>
 * The method in the class moves the information to DashboardActivity
 *
 * @author Souren
 * @since 0.1
 */

class SetupPresenter {
    private final Profile profile;
    private final View view;

    /**
     * A constructor for SetupPresenter
     *
     * @param view    the ViewSetupActivity
     * @param profile a users Profile
     */
    SetupPresenter(View view, Profile profile) {
        this.view = view;
        this.profile = profile;
    }

    /**
     * Adds the new profile information to the profile
     *
     * @param weight    a String weight
     * @param height    a String height
     * @param firstName a String first name
     * @param lastName  a String last name
     */
    void setUp(String weight, String height, String firstName, String lastName) {
        String regex = "[0-9]+[.]?[0-9]*";
        String regex2 = "^[a-zA-Z]*$";
        if(Pattern.matches(regex, weight) && Pattern.matches(regex, height) && Pattern.matches(regex2, firstName)
                && Pattern.matches(regex2, lastName)){
            profile.setUserExtraInfo(weight, height, firstName, lastName);
            view.goToDashboard(profile);
        }
        else{
            view.wrongInput();
        }

    }

    interface View {
        /**
         * Goes to the DashboardActivity
         *
         * @param profile puts in a persons profile
         */
        void goToDashboard(Profile profile);

        /**
         * Display an error message if the input doesn't meet format requirements
         */
        void wrongInput();
    }
}
