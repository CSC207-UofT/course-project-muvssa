package fitappfiles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilesTest {
    Profiles profileDatabase;
    Profile testProfile;

    @Before
    public void setUp() throws Exception {
        profileDatabase = new Profiles();
        profileDatabase.signUp("Souren", "nicePassword1", "test@gmail.com");
        profileDatabase.signUp("Other", "mypass", "cool@gmail.com");
        testProfile = new Profile("Souren", "nicePassword1", "test@gmail.com");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(timeout = 50)
    public void testSignUp() {
        assertFalse(profileDatabase.signUp("Souren",
                "nicePassword2", "test2@gmail.com"));
        assertTrue(profileDatabase.signUp("Bob",
                "nicePassword2", "test2@gmail.com"));

    }

    @Test(timeout = 50)
    public void testLoginToProfile() {
        Profile signedIn = profileDatabase.loginToProfile("Souren", "nicePassword1");
        Profile signedIn2 = profileDatabase.loginToProfile("Ted", "nicePassword1");
        Profile signedIn3 = profileDatabase.loginToProfile("Souren", "wrongpassword");
        assertEquals(testProfile.getUser().getUsername(), signedIn.getUser().getUsername());
        assertNull(signedIn2);
        assertNull(signedIn3);
    }

    @Test(timeout = 50)
    public void testSearch() {
        Profile found = profileDatabase.search("Souren");
        Profile found2 = profileDatabase.search("Jen");
        assertEquals(testProfile.getUser().getUsername(), found.getUser().getUsername());
        assertNull(found2);

    }

    @Test(timeout = 50)
    public void testsDeleteProfile() {
        profileDatabase.deleteProfile("Other", "mypass");
        Profile found = profileDatabase.search("Souren");
        Profile found2 = profileDatabase.search("Other");
        assertNull(found2);
        assertEquals(testProfile.getUser().getUsername(), found.getUser().getUsername());

    }
}