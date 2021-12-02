package com.example.fitappa.Routine;

import androidx.annotation.NonNull;
import com.example.fitappa.Workout.Workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Routine implements Serializable, Iterable<Workout> {
    private String name;
    private String description;
    private List<Workout> workouts;

    // Empty constructor necessary for Firebase
    @SuppressWarnings("unused")
    public Routine() {
    }

    /**
     * A constructor that creates a Routine given a name and list of workouts
     *
     * @param name the name of the Routine
     */
    public Routine(String name, String description) {
        this.name = name;
        this.description = description;
        this.workouts = new ArrayList<>();
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
     * Gets the description
     *
     * @return description of the Routine
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description to a given one
     *
     * @param description new description for the Routine
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of workouts
     *
     * @return list of workouts for the Routine
     */
    // TODO: Remove this since unnecessary now with iterator
    public List<Workout> getWorkouts() {
        return workouts;
    }

    /**
     * Sets the Routine's workouts to new ones given
     *
     * @param workouts list of new workouts
     */
    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    /**
     * Add a workout to the Routine
     *
     * @param workout new workout to be added
     */
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }

    /**
     * Remove a workout if the given name matches any of the workout names from the Routine
     *
     * @param name name of the workout to be removed from Routine's workouts
     */
    public void removeWorkout(String name) {
        this.workouts.removeIf(workout -> workout.getName().equals(name));
    }

    /**
     * Remove every single workout from the Routine
     */
    public void removeAllWorkouts() {
        this.workouts.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Routine))
            return false;
        Routine routine = (Routine) o;
        // erroring as when you want to update a specfic routine it could have diffrent workouts
        //return name.equals(routine.name) && description.equals(routine.description) &&
        //        workouts.equals(routine.workouts);
        return name.equals(routine.name);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NonNull
    @Override
    public Iterator<Workout> iterator() {
        return new RoutineIterator();
    }

    /**
     * Routine Iterator which allows this class to iterate over workouts
     */
    private class RoutineIterator implements Iterator<Workout> {
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
            return current < workouts.size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Workout next() {
            Workout workout;

            try {
                workout = workouts.get(current);
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
            workouts.remove(current - 1);
        }
    }
}