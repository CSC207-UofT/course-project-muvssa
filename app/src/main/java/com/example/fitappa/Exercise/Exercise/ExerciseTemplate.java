package com.example.fitappa.Exercise.Exercise;

import com.example.fitappa.Exercise.Set.Set;
import com.example.fitappa.Exercise.Set.TimedSet;
import com.example.fitappa.Exercise.Set.WeightedSet;

import java.io.Serializable;

public class ExerciseTemplate implements Serializable {
    protected String name;
    protected int numSets;
    /* These values must be constant later
    * Accepted values: REP, WEIGHTED, TIMED
    * */
    protected String category;

    /**
     * Constructor for a User class, takes in all necessary variables needed to make a User
     *
     * @param name   The String name referring to the name of the exercise
     * @param sets   The int represents the number of sets
     */
    public ExerciseTemplate(String name, int sets, String category) {
        this.name = name;
        this.numSets = sets;
        this.category = category;
    }

    // empty constructor necessary for firebase
    @SuppressWarnings("unused")
    public ExerciseTemplate() {
    }

    /**
     * Creates an Exercise object given the name.
     *
     * @param name - name of the exercise
     */
    public ExerciseTemplate(String name) {
        this.name = name;
        this.numSets = 0;
    }

    /**
     * Factory Design Pattern for Exercise objects.
     * @return the appropriate Exercise object based on this.category
     */
    public Exercise<?> create() {
        if (this.category.equals("REP"))
            return new Exercise<Set>(this.name);
        else if (this.category.equals("WEIGHTED"))
            return new Exercise<WeightedSet>(this.name);
        else
            return new Exercise<TimedSet>(this.name);
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
     * return the number of sets
     *
     * @return the int numSets
     */
    public int getNumSets() {
        return numSets;
    }



}
