package com.example.fitappa.profile;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests profile
 */
public class ProfileTest {
    Profile profile1;
    Profile profile2;


    /**
     * Sets up the class
     */
    @Before
    public void setUp(){
        this.profile1 = new Profile("johnnyappleseed@gmail.com", "Johnny", "");

        this.profile2 = new Profile("helloworld@gmail.com", "Hello", "");

    }

    /**
     * Tests get email
     */
    @Test
    public void testGetEmail() {
        assertEquals("johnnyappleseed@gmail.com", profile1.getEmail());
    }

}