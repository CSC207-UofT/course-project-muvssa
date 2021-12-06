package com.example.fitappa.Routine;

import androidx.annotation.NonNull;

import com.example.fitappa.Workout.Core.WorkoutTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class is a use case class meant to create a Routine object to hold a list of workouts
 * <p>
 * The method in the class allow the creation and interaction with a Routine holding multiple workouts
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 * @since 0.7
 */

public class Routine implements Serializable, Iterable<WorkoutTemplate> {
    private String name;
    private List<WorkoutTemplate> workoutTemplates;

    // Empty constructor necessary for Firebase
    @SuppressWarnings("unused")
    public Routine() {
        workoutTemplates = new ArrayList<>();
    }

    /**
     * A constructor that creates a Routine given a name and list of workouts
     *
     * @param name the name of the Routine
     */
    public Routine(String name) {
        this.name = name;
        this.workoutTemplates = new ArrayList<>();
    }

    /**
     * Gets the name
     *
     * @return name of the Routine
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Routine to something new
     *
     * @param name the new name of Routine
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the list of workout templates from this routine
     *
     * @return List of WorkoutTemplate corresponding to this routine
     */
    public List<WorkoutTemplate> getWorkouts() {
        return workoutTemplates;
    }

    /**
     * Sets the Routine's workouts to new ones given
     *
     * @param workoutTemplates list of new workouts
     */
    public void setWorkouts(List<WorkoutTemplate> workoutTemplates) {
        this.workoutTemplates = workoutTemplates;
    }

    /**
     * Get the size of the workouts in this routine
     *
     * @return integer size of the workouts in this routine
     */
    public int size() {
        return workoutTemplates.size();
    }

    /**
     * Add a workout to the Routine
     *
     * @param workoutTemplate new workout to be added
     */
    public void addWorkout(WorkoutTemplate workoutTemplate) {
        this.workoutTemplates.add(workoutTemplate);
    }

    /**
     * Remove a workout if the given name matches any of the workout names from the Routine
     *
     * @param name name of the workout to be removed from Routine's workouts
     */
    public void removeWorkout(String name) {
        this.workoutTemplates.removeIf(workout -> workout.getName().equals(name));
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NonNull
    @Override
    public Iterator<WorkoutTemplate> iterator() {
        return new RoutineIterator();
    }

    /**
     * Routine Iterator which allows this class to iterate over workouts
     */
    private class RoutineIterator implements Iterator<WorkoutTemplate> {
        private int current = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current < workoutTemplates.size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public WorkoutTemplate next() {
            WorkoutTemplate workout;

            try {
                workout = workoutTemplates.get(current);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current += 1;
            return workout;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            workoutTemplates.remove(current - 1);
        }
    }
}