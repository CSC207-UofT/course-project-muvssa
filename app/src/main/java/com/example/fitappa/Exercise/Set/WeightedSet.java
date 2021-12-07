package com.example.fitappa.Exercise.Set;

import androidx.annotation.NonNull;

/**
 * A weighted set stores information about the number of reps,
 * the magnitude of the weight in LB.
 *
 * The methods help initialize what a weighted set should be
 *
 * The documentation in this class give a specification on what the methods do
 *
 * @author Abdullah
 *
 * @since 0.2
 */
public class WeightedSet extends RepSet implements Set {

    private final double weight;

    /**
     * Creates a WeightedSet with the given weight and numReps = 0.
     * @param weight represents the given weight in lb
     */
    public WeightedSet(double numReps, double weight) {
        super(numReps);
        this.weight = weight;
    }

    @NonNull
    @Override
    public String toString() {
        return "Weight: " + this.weight  + "lbs | Reps: " + this.numReps + "";
    }
}
