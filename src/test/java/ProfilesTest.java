import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfilesTest {
    Profiles profileDatabase;
    Profile testProfile;

    @Before
    public void setUp() throws Exception {
        profileDatabase = new Profiles();
        profileDatabase.signUp("Souren","nicePassword1", "test@gmail.com");
        profileDatabase.signUp("Other", "mypass", "cool@gmail.com");
        testProfile = new Profile("Souren","nicePassword1", "test@gmail.com");

    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSignUp() {
        assertEquals(false, profileDatabase.signUp("Souren",
                "nicePassword2", "test2@gmail.com"));
        assertEquals(true, profileDatabase.signUp("Bob",
                "nicePassword2", "test2@gmail.com"));

    }

    @Test
    public void testLoginToProfile() {
        Profile signedIn = profileDatabase.loginToProfile("Souren","nicePassword1");
        Profile signedIn2 = profileDatabase.loginToProfile("Ted","nicePassword1");
        Profile signedIn3 = profileDatabase.loginToProfile("Souren","wrongpassword");
        assertEquals(testProfile, signedIn);
        //assertEquals(null, signedIn2);
        //assertEquals(null, signedIn3);
    }

    @Test
    public void testSearch() {
        Profile found = profileDatabase.search("Souren");
        Profile found2 = profileDatabase.search("Jen");
        assertEquals(testProfile, found);
        //assertEquals(null, found2);

    }

    @Test
    public void testsDeleteProfile() {
        profileDatabase.deleteProfile("Other", "mypass");
        Profile found = profileDatabase.search("Souren");
        Profile found2 = profileDatabase.search("Other");
        //assertEquals(null, found2);
        //assertEquals(testProfile, found);

    }
}