package com.example.fitappa.Workout;

import com.example.fitappa.Workout.Core.PerformWorkout;
import com.example.fitappa.Workout.Core.WorkoutTemplate;

public class TrackWorkoutPresenter {
    View view;
    PerformWorkout performWorkout;
    final String PAGE_TITLE = "Start Workout";

    public TrackWorkoutPresenter(View view, WorkoutTemplate template)
    {
        this.view = view;
        this.performWorkout = new PerformWorkout(template);
        this.view.populateLayout(template);
        this.view.updateTitle(template.getName());
        this.view.updateAppBarTitle(PAGE_TITLE);
    }

    // Dependency Inversion
    interface View {
        void updateAppBarTitle(String title);
        void updateTitle(String workoutTitle);
        void populateLayout(WorkoutTemplate template);
    }
}
