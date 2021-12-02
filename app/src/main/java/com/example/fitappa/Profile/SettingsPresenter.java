package com.example.fitappa.Profile;

/**
 * This class is a presenter class for ViewSettingActivity
 * <p>
 * The methods in this class help move information to and from the ViewSettingActivity class
 *
 * @author Souren
 * @since 0.1
 */

class SettingsPresenter {
    private final Profile profile;
    private final View view;

    /**
     * A constructor for SettingPresenter
     *
     * @param view    the ViewSettingActivity
     * @param profile a users Profile
     */
    SettingsPresenter(View view, Profile profile) {
        this.view = view;
        this.profile = profile;
    }

    /**
     * retrieve user's weight
     *
     * @return string of their weight
     */
    String getSettingWeight() {
        return profile.getUserWeight();
    }

    /**
     * retrieve user's height
     *
     * @return string of their height
     */
    String getSettingHeight() {
        return profile.getUserHeight();
    }

    /**
     * retrieve a user's first name
     *
     * @return string of their first name
     */
    String getSettingFirstName() {
        return profile.getUserFirstName();
    }

    /**
     * retrieve a user's last name
     *
     * @return string of their last name
     */
    String getSettingLastName() {
        return profile.getUserLastName();
    }

    /**
     * Will change a users extra information like weight, height, first name, and last name. It will also not change
     * anything if the user hasn't made any edits.
     *
     * @param w user inputted string weight
     * @param h user inputted string height
     * @param f user inputted string first name
     * @param l user inputted string last name
     */
    void changeSettings(String w, String h, String f, String l) {
        if (w.equals("")) {
            w = profile.getUserWeight();
        }
        if (h.equals("")) {
            h = profile.getUserHeight();
        }
        if (f.equals("")) {
            f = profile.getUserFirstName();
        }
        if (l.equals("")) {
            l = profile.getUserLastName();
        }
        profile.setUserExtraInfo(w, h, f, l);
        profile.saveData();
        view.update();
    }

    interface View {
        /**
         * Display the changes the user made to their settings
         */
        void update();
    }
}