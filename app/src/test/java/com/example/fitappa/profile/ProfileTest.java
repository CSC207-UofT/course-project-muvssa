package com.example.fitappa.profile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {
    Profile profile1;
    Profile profile2;
    @Before
    public void setUp() throws Exception {
        //two profile objects are made
        profile1 = new Profile("johnnyappleseed@gmail.com", "Johnny", "101290");
        profile2 = new Profile("helloworld@gmail.com", "Hello", "239092");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEmail() {
        //sees if the desired string matches the one that's got
        assertEquals("johnnyappleseed@gmail.com", profile1.getEmail());
        assertEquals("helloworld@gmail.com", profile2.getEmail());
    }
    @Test
    public void getUsername() {
        //sees if the desired string matches the one that's got
        assertEquals("Johnny", profile1.getUsername());
        assertEquals("Hello", profile2.getUsername());
    }

    @Test
    public void getUniqueID() {
        //sees if the desired string matches the one that's got
        assertEquals("101290", profile1.getUniqueID());
        assertEquals("239092", profile2.getUniqueID());
    }

    @Test
    public void setgetWeight() {
        //sees if the desired string matches the one that's set and gotten
        profile1.setWeight("140");
        profile2.setWeight("160");
        assertEquals("140", profile1.getWeight());
        profile1.setWeight(profile2.getWeight());
        assertEquals("160", profile1.getWeight());
    }

    @Test
    public void setgetHeight() {
        //sees if the desired string matches the one that's set and gotten
        profile1.setHeight("75");
        profile2.setHeight("90");
        assertEquals("75", profile1.getHeight());
        assertEquals("90", profile2.getHeight());
        profile2.setHeight(profile1.getHeight());
        assertEquals("75", profile2.getHeight());
    }

    @Test
    public void setgetFirstName() {
        //sees if the desired string matches the one that's set and gotten
        profile1.setFirstName("John");
        assertEquals("John", profile1.getFirstName());
        profile1.setFirstName("Jack");
        assertEquals("Jack", profile1.getFirstName());
        profile2.setFirstName(profile1.getFirstName());
        assertNotEquals("John", profile2.getFirstName());
    }

    @Test
    public void setgetLastName() {
        //sees if the desired string matches the one that's set and gotten
        profile1.setFirstName("John");
        assertNull(profile1.getLastName());
        profile1.setLastName("Apple");
        assertEquals("Apple", profile1.getLastName());
        profile2.setLastName("World");
        profile2.setLastName(profile1.getFirstName());
        assertEquals("John", profile2.getLastName());
    }
}