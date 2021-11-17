package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.Profile;

public interface UpdatesView {
    /**
     * Update UI given a profile
     *
     * @param profile profile to update UI with
     */
    void updateUI(Profile profile);
}
