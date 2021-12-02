package com.example.fitappa.Routine;

import com.example.fitappa.Profile.Profile;

class ViewRoutinesPresenter {
    private final Profile profile;
    private final View view;

    /**
     * View for the routines
     *
     * @param view    represents the view of the routines as type View
     * @param profile represents the user's profile as type Profile
     */
    ViewRoutinesPresenter(View view, Profile profile) {
        this.view = view;
        this.profile = profile;
    }

    /**
     * Adds a routine the the user's profile and updates the view of the routines
     *
     * @param name represents the name of the routine as type String
     */
    void addRoutine(String name) {
        Routine r = new Routine(name, "");
        this.profile.addRoutine(r);
        view.updateRoutinesView(r);
    }


    // Dependency Inversion
    interface View {
        void updateRoutinesView(Routine routine);
    }

}

