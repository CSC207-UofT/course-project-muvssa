package com.example.fitappa.Presenter;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;

import java.util.ArrayList;
import java.util.List;

public class ViewRoutinesPresenter {
    private Profile profile;
    private View view;

    public ViewRoutinesPresenter(View view, Profile profile) {
        this.view = view;
        this.profile = profile;
    }

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

