package fitappfiles;

import com.example.fitappa.Model.Entity.User;
import junit.framework.TestCase;

public class UserTest extends TestCase {
    User user_1;

    public void setUp() throws Exception {
        user_1 = new User("abcd", "damnsana", "abcd");

        super.setUp();
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
}