package com.example.fitappa.Authentication;

import com.example.fitappa.Profile.Profile;

public interface GoesToDashboard {

    /**
     * Open the DashboardActivity and pass a profile to it
     *
     * @param profile Profile to be passed to Dashboard
     */
    void openDashboard(Profile profile);
}
