package com.example.fitappa.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TimedExercise extends Exercise implements Serializable {

    private List<TimedSet> sets;

    public TimedExercise(String name) {
        super(name);
        this.sets = new ArrayList<TimedSet>();
    }

    @Override
    public double volume() {
        return 0;
    }
}