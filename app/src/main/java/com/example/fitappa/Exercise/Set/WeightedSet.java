package com.example.fitappa.Exercise.Set;

public class WeightedSet extends RepSet implements Settable {

    private final double weight;

    /**
     * Creates a WeightedSet with the given weight and numReps = 0.
     * @param weight represents the given weight
     */
    public WeightedSet(double numReps, double weight) {
        super(numReps);
        this.weight = weight;
    }

    /**
     * The volume of a weighted set is weight * number of reps
     * @return the volume of this set
     */
    @Override
    public double volume() {
        return weight * this.numReps;
    }
}
