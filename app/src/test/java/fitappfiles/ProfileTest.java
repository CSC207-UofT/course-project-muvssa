package fitappfiles;

import com.example.fitappa.Model.Entity.User;
import com.example.fitappa.Model.UseCase.FollowManager;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;
import com.example.fitappa.R;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ProfileTest extends TestCase {
    Profile profile;
    Profile profile2;
    User user;
    User user2;
    FollowManager userf;
    FollowManager user2f;
    FollowManager user3f;
    Routine routine;


    public void setUp() throws Exception {
        profile = new Profile("Johnny", "johnny123", "johnnyappleseed@gmail.com");
        profile2 = new Profile("Hello", "world123", "helloworld@gmail.com");
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetUser() {
        user = new User("Johnny", "johnny123", "johnnyappleseed@gmail.com");
        user2 = new User("Hello", "world123", "helloworld@gmail.com");
        // sees if usernames and other elements of user matches that of the
        // user returned by getUser()
        assertNotSame(user.getUsername(), profile.getUser().getUsername());
        assertEquals(user2.getPassword(), profile.getUser().getPassword());
        assertEquals(user2.getEmail(), profile.getUser().getEmail());
    }

    public void testGetProfileFollow() {
        user3f = new FollowManager(profile.getUser());
        assertNotSame(user3f, profile.getProfileFollow()); //shows same data types are being compared
        //shows the getter works
        userf = profile.getProfileFollow();
        user2f = profile2.getProfileFollow();
        assertTrue(userf.getFollowers().containsKey("follower"));
        assertEquals(user2f, profile2.getProfileFollow());
        assertNotSame(userf, profile2.getProfileFollow()); //shows userf is not equal to user2f
    }

    public void testGetRoutines() {
        //shows that it matches the elements of the
        // hard coded routines
        assertEquals("My routine", profile.getRoutines().get(0).getName());
        assertEquals("My routine2", profile2.getRoutines().get(1).getName());
    }

    public void testAddRoutine() {
        //shows that the element has been added by looking at
        //size and matching name
        profile2.addRoutine(new Routine("My routine3", "My new routine"));
        assertEquals("My routine3", profile2.getRoutines().get(2).getName());
        assertEquals(3, profile2.getRoutines().size());

    }
}