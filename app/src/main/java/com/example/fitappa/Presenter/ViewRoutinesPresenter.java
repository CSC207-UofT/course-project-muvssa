package com.example.fitappa.Presenter;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;

import java.util.ArrayList;
import java.util.List;

public class ViewRoutinesPresenter {
    private Profile profile;
    private View view;

    /**
     * View for the routines
     * @param view represents the view of the routines as type View
     * @param profile represents the user's profile as type Profile
     */
    public ViewRoutinesPresenter(View view, Profile profile) {
        this.view = view;
        this.profile = profile;
    }

    /**
     * Adds a routine the the user's profile and updates the view of the routines
     * @param name represents the name of the routine as type String
     */
    public void addRoutine(String name) {
        Routine r = new Routine(name, "");
        this.profile.addRoutine(r);
        view.updateRoutinesView(r);
    }


    // Dependency Inversion
    public interface View
    {
        void updateRoutinesView(Routine routine);
    }

}

