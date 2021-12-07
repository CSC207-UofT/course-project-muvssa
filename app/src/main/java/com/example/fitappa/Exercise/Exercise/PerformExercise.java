package com.example.fitappa.Exercise.Exercise;
import androidx.annotation.NonNull;

import com.example.fitappa.Exercise.Set.Set;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class represents a general exercise.
 *
 * Every exercise must have the type of sets they must use.
 * For example, a exercise like bench press involves weight & reps
 * while an exercise like running involves time.
 *
 * @param <T> represents the type of set that the exercise uses
 *
 * @author abdullah
 * @version 0.1
 */
public class PerformExercise<T> implements Serializable {
    private final String name;
    private final List<T> sets;
    private final Category category;
    private final UUID identifier;

    /**
     * Constructor for a Exercise class, takes in all necessary variables needed to make a
     * Exercise
     *
     * @param name The String name referring to the name of the exercise
     */
    public PerformExercise(String name, Category category) {
        this.name = name;
        this.category = category;
        this.sets = new ArrayList<>();
        this.identifier = UUID.randomUUID();
    }

    /**
     * Get the unique identifier for this exercise
     * @return this.identifier
     */
    public String getIdentifier() {
        return this.identifier.toString();
    }

    /**
     * Getter for category
     * @return this.category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * returns the name of the exercise
     *
     * @return the string name
     */
    public String getName() {
        return name;
    }

    /**
     * A crucial component of an exercise is the ability to add sets
     * However, every exercise is different and has different types of sets.
     * Sometimes the sets are completely unrelated.
     *
     * Precondition: s is of type T.
     *
     * @param s represents the set
     */
    @SuppressWarnings("unchecked")
    public void addSet(Set s) {
        this.sets.add((T) s);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(this.name).append(" with the following sets: \n");

        for (T set : this.sets) {
            s.append(set.toString()).append("\n");
        }

        return s.toString();
    }

}