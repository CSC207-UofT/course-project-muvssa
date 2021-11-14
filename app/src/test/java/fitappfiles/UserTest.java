package fitappfiles;

import com.example.fitappa.Model.User;
import junit.framework.TestCase;

public class UserTest extends TestCase {
    User user_1;

    public void setUp() throws Exception {
        user_1 = new User("damnsana", "abcd", "abcd");

        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetUsername() {
        assertEquals("damnsana", user_1.getUsername());
    }

    public void testGetPassword() {
        assertEquals("abcd", user_1.getPassword());
    }

    public void testGetEmail() {
        assertEquals("abcd", user_1.getEmail());
    }

    public void testSetPassword() {
        user_1.setPassword("abc");
        assertEquals("abc", user_1.getPassword());
    }

    public void testLogin() {
        assertTrue(user_1.login("damnsana", "abcd"));
        assertFalse(user_1.login("damnsana", "djhfskj"));
        assertFalse(user_1.login("shsh", "abcd"));
    }
}