package com.example.fitappa.workout.track_workout;

import androidx.annotation.NonNull;

import com.example.fitappa.exercise.exercise_template.CreatableExercise;
import com.example.fitappa.exercise.set.SetFactory;
import com.example.fitappa.workout.workout_template.WorkoutTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a workout that can be performed.
 *
 * @author Abdullah
 * @version 0.1
 * @layer 2
 */
class PerformWorkout implements Iterable<PerformExercise<?>> {
    private final List<PerformExercise<?>> exercises;
    private final SetFactory setFactory;
    private final String name;
    private LocalDateTime startTime;
    // For later use
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private LocalDateTime endTime;

    /**
     * Creates a new Workout
     *
     * @param template represents the workout template that this workout is based off of
     */
    PerformWorkout(WorkoutTemplate template) {
        this.name = template.getName();
        this.exercises = new ArrayList<>();
        this.setFactory = new SetFactory();
        // Dependency inversion to ensure no violation of clean :-)
        for (CreatableExercise exerciseTemplate : template) {
            this.exercises.add(exerciseTemplate.create());
        }
    }


    List<PerformExercise<?>> getExercises() {
        return this.exercises;
    }

    /**
     * Getter for this.name
     *
     * @return the name of the workout
     */
    String getName() {
        return this.name;
    }

    /**
     * This method starts a workout. A workout can be started iff it wasn't started before
     */
    void start() {
        this.startTime = LocalDateTime.now();
    }


    /**
     * Precondition: exercise with Identifier UID exists.
     */
    private PerformExercise<?> getExerciseByUID(String uid) {
        for (PerformExercise<?> e : this.exercises) {
            if (e.getIdentifier().equals(uid)) {
                return e;
            }
        }
        return null;
    }


    /**
     * Precondition: 1) 0 <= i < this.currWorkout.length(),
     * 2) the exercise at position <i> is of type RepExercise
     *
     * @param uid     represents the unique id of the exercise
     * @param numReps represents the number of reps to add in the set
     */
    void addSet(String uid, int numReps) {
        Objects.requireNonNull(getExerciseByUID(uid)).addSet(setFactory.buildSet(numReps));

    }

    /**
     * Precondition: 1) 0 <= i < this.currWorkout.length(),
     * 2) the exercise at position <i> is of type WeightedExercise
     *
     * @param uid     represents the unique id of the exercise
     * @param numReps represents the number of reps to add in the set
     * @param weight  represents the weight to add in the set
     */
    void addSet(String uid, int numReps, double weight) {
        Objects.requireNonNull(getExerciseByUID(uid)).addSet(setFactory.buildSet(numReps, weight));
    }

    /**
     * This method ensures that the workout is finished.
     * <p>
     * A workout is finished when this.isFinished() == true
     */
    void finish() {
        this.endTime = LocalDateTime.now();
    }


    @SuppressWarnings("rawtypes")
    @NonNull
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder stringBuilder = new StringBuilder("The workout \"");
        stringBuilder.append(this.name);
        stringBuilder.append("\" was performed on ").append(this.startTime.format(formatter)).append(" with the following exercises: \n");

        for (PerformExercise performedExercise : this.exercises) {
            stringBuilder.append("\n").append(performedExercise.toString());
        }

        stringBuilder.append("\n---------------------------------");

        return stringBuilder.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NonNull
    @Override
    public Iterator<PerformExercise<?>> iterator() {
        return exercises.iterator();
    }
}
