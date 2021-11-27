package com.example.fitappa.Profile;

import junit.framework.TestCase;

public class UserTest extends TestCase {
    User user_1;

    public void setUp() throws Exception {
        user_1 = new User("abcd", "damnsana");

        super.setUp();
    }

    public void testGetUsername() {
        assertEquals("damnsana", user_1.getUsername());
    }

    public void testGetEmail() {
        assertEquals("abcd", user_1.getEmail());
    }
}