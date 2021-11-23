package com.example.fitappa.Model.Entity;

import java.io.Serializable;

public class RepExercise extends Exercise implements Serializable {

    private final int numReps;

    public RepExercise(String name, int sets, int rest, String muscle, int numReps) {
        super(name, sets, rest, muscle);
        this.numReps = numReps;
    }

    /**
     * Creates a RepExercise Object given another
     *
     * @param other another rep exercise
     */
    public RepExercise(RepExercise other) {
        super(other);
        this.numReps = 0;
    }

    /**
     * Creates a RepExercise object given the name
     *
     * @param name name of the rep exercise
     */
    public RepExercise(String name) {
        super(name);
        this.numReps = 0;
    }

    public int getNumReps() {
        return numReps;
    }


    @Override
    public double getVolume() {
        return this.numReps * super.numSets;
    }
}

