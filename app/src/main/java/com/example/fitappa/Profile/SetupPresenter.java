package com.example.fitappa.Profile;

import android.widget.EditText;

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
     * @param w    a EditText weight
     * @param h    a EditText height
     * @param f a EditText first name
     * @param l  a EditText last name
     */
    void setUp(EditText w, EditText h, EditText f, EditText l) {
        String regex = "[0-9]+[.]?[0-9]*";
        String regex2 = "^[a-zA-Z]*$";

        String weight = w.getText().toString();
        String height = h.getText().toString();
        String firstName = f.getText().toString();
        String lastName = l.getText().toString();
        if(!Pattern.matches(regex, weight)){
            w.setError("please input pounds");
            w.requestFocus();
        }
        if(!Pattern.matches(regex, height)){
            h.setError("please input cm");
            h.requestFocus();
        }
        if(!Pattern.matches(regex2, firstName)){
            f.setError("please letters");
            f.requestFocus();
        }
        if(!Pattern.matches(regex2, lastName)){
            l.setError("please input letters");
            l.requestFocus();
        }

        if(Pattern.matches(regex, weight) && Pattern.matches(regex, height) && Pattern.matches(regex2, firstName)
                && Pattern.matches(regex2, lastName)){
            profile.setUserExtraInfo(weight, height, firstName, lastName);

            Saveable gateway = new SaveProfileGateway();
            profile.saveData(gateway);

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
