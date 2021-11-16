package com.example.fitappa.Model.Entity;

import java.io.Serializable;

public class TimedExercise extends Exercise implements Serializable {

    private final int set_time;

    public TimedExercise(String name, int sets, int rest, String muscle, int set_time) {
        super(name, sets, rest, muscle);
        this.set_time = set_time;
    }

    public TimedExercise(TimedExercise other) {
        super(other);
        this.set_time = 0;
    }

    public int getSet_time() {
        return set_time;
    }


    @Override
    public double getVolume() {
        return super.numSets * this.set_time;
    }
}