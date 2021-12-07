package com.example.fitappa.Profile;

import static org.junit.Assert.assertEquals;

import com.example.fitappa.Routine.Routine;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
    Profile profile1;
    Profile profile2;
    Routine routine1;
    Routine routine2;


    @Before
    public void setUp() throws Exception {
        this.routine1 = new Routine("My routine");
        this.routine2 = new Routine("My routine2");

        this.profile1 = new Profile("johnnyappleseed@gmail.com", "Johnny", "");

        this.profile2 = new Profile("helloworld@gmail.com", "Hello", "");

    }

    @Test
    public void testGetEmail() {
        assertEquals("johnnyappleseed@gmail.com", profile1.getEmail());
    }

    @Test
    public void testGetRoutines() {
        // shows that it matches the elements of the
        // hard coded routines
//        assertEquals(routine1, profile1.getRoutines().get(0));
//        assertEquals(routine2, profile2.getRoutines().get(0));
    }

    @Test
    public void testAddRoutine() {
        // shows that the element has been added by looking at
        // size and matching name
//        profile2.addRoutine(new Routine("My routine3"));
//        assertEquals("My routine3", profile2.getRoutines().get(1).getName());
//        assertEquals(2, profile2.getRoutines().size());

    }
}