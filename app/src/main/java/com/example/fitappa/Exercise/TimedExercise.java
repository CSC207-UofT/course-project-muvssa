package com.example.fitappa.Exercise;

import java.io.Serializable;

public class TimedExercise extends Exercise implements Serializable {

    private final int setTime;

    public TimedExercise(String name, int sets, int rest, String muscle, int set_time) {
        super(name, sets, rest, muscle);
        this.setTime = set_time;
    }

    public TimedExercise(TimedExercise other) {
        super(other);
        this.setTime = 0;
    }

    public int getSetTime() {
        return setTime;
    }


    @Override
    public double getVolume() {
        return super.numSets * this.setTime;
    }
}