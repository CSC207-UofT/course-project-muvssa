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

class SetupPresenter implements LoadsProfile {
    private final View view;

    String weight;
    String height;
    String firstName;
    String lastName;

    /**
     * A constructor for SetupPresenter
     *
     * @param view the ViewSetupActivity
     */
    SetupPresenter(View view) {
        this.view = view;
    }

    @Override
    public void loadProfile(Profile profile) {
        profile.setExtraInfo(weight, height, firstName, lastName);

        Saveable gateway = new SaveProfileGateway();
        gateway.save(profile);
    }

    /**
     * Adds the new profile information to the profile
     *
     * @param w a EditText weight
     * @param h a EditText height
     * @param f a EditText first name
     * @param l a EditText last name
     */
    void setUp(EditText w, EditText h, EditText f, EditText l) {
        String regex = "[0-9]+[.]?[0-9]*";
        String regex2 = "^[a-zA-Z]*$";

        this.weight = w.getText().toString();
        this.height = h.getText().toString();
        this.firstName = f.getText().toString();
        this.lastName = l.getText().toString();

        if (!Pattern.matches(regex, weight)) {
            w.setError("please input pounds");
            w.requestFocus();
        }
        if (!Pattern.matches(regex, height)) {
            h.setError("please input cm");
            h.requestFocus();
        }
        if (!Pattern.matches(regex2, firstName)) {
            f.setError("please input letters");
            f.requestFocus();
        }
        if (!Pattern.matches(regex2, lastName)) {
            l.setError("please input letters");
            l.requestFocus();
        }

        if (Pattern.matches(regex, weight) && Pattern.matches(regex, height) && Pattern.matches(regex2, firstName)
                && Pattern.matches(regex2, lastName)) {

            Loadable gateway = new ProfileReader(this);
            gateway.load();

            view.goToDashboard();
        } else {
            view.setError();
        }

    }

    interface View {
        /**
         * Goes to the DashboardActivity
         */
        void goToDashboard();

        /**
         * Display an error message if the input doesn't meet format requirements
         */
        void setError();
    }
}
