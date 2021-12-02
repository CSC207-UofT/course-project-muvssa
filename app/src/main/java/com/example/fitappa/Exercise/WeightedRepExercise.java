package com.example.fitappa.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeightedRepExercise extends RepExercise implements Serializable {

    private List<WeightedSet> sets;

    public WeightedRepExercise(String name) {
        super(name);
        this.sets = new ArrayList<WeightedSet>();
    }

}