package com.example.fitappa.Exercise.Exercise;
import com.example.fitappa.Exercise.Set.Set;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class Exercise<T> implements Serializable {
    protected String name;
    protected List<T> sets;

    /**
     * Constructor for a Exercise class, takes in all necessary variables needed to make a
     * Exercise
     *
     * @param name   The String name referring to the name of the exercise
     */
    public Exercise(String name) {
        this.name = name;
        this.sets = new ArrayList<>();
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
     * We define volume to be the total work done in an exercise. The exact computation of volume highly depends
     * on the type of exercise.
     *
     * @return the total volume generated by this exercise.
     */
    public double volume() {
        double vol = 0;
        for(T s : sets) {
            vol += ((Set) s).volume();
        }
        return vol;
    }
    /**
     * return the number of sets in the Exercise
     * @return size of this.sets
     */
    public int numSets() {
        return this.sets.size();
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

}