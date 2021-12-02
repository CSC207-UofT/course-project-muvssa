package com.example.fitappa.Exercise;

import com.example.fitappa.Exercise.Exercise.RepExercise;
import com.example.fitappa.Exercise.Set.Set;

import junit.framework.TestCase;

public class RepExerciseTest extends TestCase {
    RepExercise exercise;

    public void setUp() throws Exception {
        this.exercise = new RepExercise("Jumping");
        super.setUp();
    }

    public void testSets() {
        exercise.addSet(new Set(10));
        assertEquals(1, exercise.numSets());
        exercise.addSet(new Set(10));
        exercise.addSet(new Set(10));
        assertEquals(3, exercise.numSets());
    }

}