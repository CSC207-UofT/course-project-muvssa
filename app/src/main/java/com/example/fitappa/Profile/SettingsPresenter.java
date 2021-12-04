package com.example.fitappa.Profile;

import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * This class is a presenter class  meant to send and receive information from the back end to help ViewSettingActivity
 *
 * The methods in this class help move information to and from the ViewSettingActivity class
 *
 * The documentation in this class give a specification on what the methods do
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
     * @param w user inputted EditText weight
     * @param h user inputted EditText height
     * @param f user inputted EditText first name
     * @param l user inputted EditText last name
     */
    void changeSettings(EditText w, EditText h, EditText f, EditText l) {

        String regex = "[0-9]+[.]?[0-9]*";
        String regex2 = "^[a-zA-Z]*$";

        String weight = w.getText().toString();
        String height = h.getText().toString();
        String first = f.getText().toString();
        String last = l.getText().toString();

        if (weight.equals("")){
            weight = profile.getUserWeight();
        }
        else if(!Pattern.matches(regex, weight)){
            w.setError("please input pounds");
            w.requestFocus();
            weight = profile.getUserWeight();
        }

        if (height.equals("") ) {
            height = profile.getUserHeight();
        }
        else if(!Pattern.matches(regex, height)){
            System.out.println();
            h.setError("please input cm");
            h.requestFocus();
            height = profile.getUserHeight();
        }

        if (first.equals("") ) {
            first = profile.getUserFirstName();
        }
        else if(!Pattern.matches(regex2, first)){
            f.setError("please letters");
            f.requestFocus();
            first = profile.getUserFirstName();
        }

        if (last.equals("")) {
            last = profile.getUserLastName();
        }
        else if(!Pattern.matches(regex2, last)){
            l.setError("please input letters");
            l.requestFocus();
            last = profile.getUserLastName();
        }
        profile.setUserExtraInfo(weight, height, first, last);
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