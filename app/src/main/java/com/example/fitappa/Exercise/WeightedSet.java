package com.example.fitappa.Exercise;

public class WeightedSet extends Set implements Settable {

    private double weight;

    /**
     * Creates a WeightedSet with the given weight and numReps = 0.
     * @param weight represents the given weight
     */
    public WeightedSet(double numReps, double weight) {
        super(numReps);
        this.weight = weight;
    }


    /**
     * TODO: javadoc
     * @return
     */
    @Override
    public double volume() {
        return weight * this.numReps;
    }
}
