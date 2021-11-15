package com.example.fitappa.Presenter;

import android.util.Log;
import com.example.fitappa.Model.Entity.Workout;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;

public class ViewRoutinePresenter {
    private Routine routine;
    private View view;

    public ViewRoutinePresenter(View view, Routine routine)
    {
        this.view = view;
        this.routine = routine;
    }


    public void addWorkout(String workoutName) {
        // TODO: Fix bug, apparently w1 is null.
        Workout w1 = new Workout(workoutName, "test");
        this.routine.addWorkout(w1);
        view.updateRoutineView(w1);
    }

    public interface View
    {
        void updateRoutineView(Workout workout);
    }
}
