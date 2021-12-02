package com.example.fitappa.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepExercise extends Exercise implements Serializable {

    private List<Set> sets;

    public RepExercise(String name) {
        super(name);
        this.sets = new ArrayList<Set>();
    }

    public void addSet(Settable s) {
        this.sets.add((Set) s);
    }

    public int numSets() {
        int count = 0;
        for (Set s : sets) {
            count++;
        }
        return count;
    }


    @Override
    public double volume() {
        return 0;
    }
}
