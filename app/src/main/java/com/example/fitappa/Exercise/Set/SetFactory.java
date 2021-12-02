package com.example.fitappa.Exercise.Set;

public class SetFactory {

    public SetFactory() {

    }

    public Set buildSet(int numReps) {
        return new Set(numReps);
    }

    public WeightedSet buildSet(int numReps, double weight) {
        return new WeightedSet(numReps, weight);
    }

    public TimedSet buildSet(double time) {
        return new TimedSet(time);
    }

}
