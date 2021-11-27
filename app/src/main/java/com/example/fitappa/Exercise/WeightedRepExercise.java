package com.example.fitappa.Exercise;

import java.io.Serializable;

public class WeightedRepExercise extends RepExercise implements Serializable {

    private final double weight;

    public WeightedRepExercise(String name, int sets, int rest, String muscle, int numRep, double weight) {
        super(name, sets, rest, muscle, numRep);
        this.weight = weight;
    }

    /**
     * Creates another WeightedRepExercise given another
     *
     * @param other - another
     */
    public WeightedRepExercise(WeightedRepExercise other) {
        super(other);
        this.weight = other.weight;
    }

    public WeightedRepExercise(String name) {
        super(name);
        weight = 0;
    }

    public double getWeight() {
        return weight;
    }
}