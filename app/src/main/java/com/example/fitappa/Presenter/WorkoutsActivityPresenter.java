package com.example.fitappa.Presenter;
import android.view.View;
import com.example.fitappa.Model.*;

import java.util.ArrayList;

public class WorkoutsActivityPresenter {
    private Profile profile;
    private View view;
    private ArrayList<Routine> routines;


    public WorkoutsActivityPresenter(View view, Profile profile) {
        this.view = view;
        this.profile = profile;
    }


    // Dependency Inversion
    public interface View
    {
        void updateRoutinesView(ArrayList<Routine> routines);
    }

}


