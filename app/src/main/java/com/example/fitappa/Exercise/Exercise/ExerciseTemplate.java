package com.example.fitappa.Exercise.Exercise;

import com.example.fitappa.Exercise.Set.RepSet;
import com.example.fitappa.Exercise.Set.WeightedSet;

import java.io.Serializable;

/**
 * This class stores a template of an exercise.
 * <p>
 * The methods create a template which can create an Exercise object using the
 * factory design pattern.
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author abdullah
 * @version 0.1
 * @layer 1.
 */
public class ExerciseTemplate implements Serializable, CreatableExercise {
    protected String name;
    protected int numSets;
    /* These values must be constant later
     * Accepted values: REP, WEIGHTED, TIMED
     * */
    protected Category category;

    /**
     * Constructor for an Exercise class, takes in all necessary variables needed to make an
     * Exercise Template
     *
     * @param name The String name referring to the name of the exercise
     * @param sets The int represents the number of sets
     */
    public ExerciseTemplate(String name, int sets, Category category) {
        this.name = name;
        this.numSets = sets;
        this.category = category;
    }

    /**
     * Empty constructor needed by firebase
     */
    @SuppressWarnings("unused")
    public ExerciseTemplate() {
        numSets = 0;
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
     * Note that this method was implemented due to the CreatableExercise interface
     *
     * @return the appropriate Exercise object based on this.category
     */
    public PerformExercise<?> create() {
        if (category == Category.REP) {
            return new PerformExercise<RepSet>(this.name, Category.REP);
        }
        return new PerformExercise<WeightedSet>(this.name, Category.WEIGHTED);
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

    /**
     * Necessary method for Firebase
     */
    @SuppressWarnings("unused")
    public Category getCategory() {
        return category;
    }
}
