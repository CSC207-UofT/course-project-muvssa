package fitappfiles;

import junit.framework.TestCase;

public class CommentTest extends TestCase {
    User user_1;
    User user_2;
    Comment x;
    Comment y;

    public void setUp() throws Exception {
        user_2 = new User("as", "lol", "qw");
        user_1 = new User("xox", "abc", "xo");
        x = new Comment(user_1, "I love noodles");
        y = new Comment(user_2, "I am a girl");
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetContent() {
        assertEquals("I love noodles", x.getContent());
        assertEquals("I am a girl", y.getContent());
    }

    public void testSetContent() {
        x.setContent("hello");
        assertEquals("hello", x.getContent());
        x.setContent("bye");
        assertEquals("bye", x.getContent());
    }

    public void testGetUsername() {
        assertEquals("xox", user_1.getUsername());
        assertEquals("as", user_2.getUsername());
    }
}