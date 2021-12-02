package com.example.fitappa.Exercise.Exercise;

import com.example.fitappa.Exercise.Exercise.RepExercise;
import com.example.fitappa.Exercise.Set.Settable;
import com.example.fitappa.Exercise.Set.WeightedSet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeightedRepExercise extends RepExercise implements Serializable {

    private List<WeightedSet> sets;

    public WeightedRepExercise(String name) {
        super(name);
        this.sets = new ArrayList<WeightedSet>();
    }

    @Override
    public void addSet(Settable s) {
        this.sets.add((WeightedSet) s);
    }


}