package fitappfiles;

import com.example.fitappa.Model.Entity.User;
import com.example.fitappa.Model.Gateway.FirebaseGateway;
import com.example.fitappa.Model.Gateway.Saveable;
import com.example.fitappa.Model.UseCase.FollowManager;
import com.example.fitappa.Model.UseCase.Profile;
import com.example.fitappa.Model.UseCase.Routine;
import junit.framework.TestCase;

public class ProfileTest extends TestCase {
    Profile profile1;
    Profile profile2;
    User user1;
    User user2;
    FollowManager userf;
    FollowManager user2f;
    FollowManager user3f;
    Routine routine;


    public void setUp() throws Exception {
        Saveable gateway = new FirebaseGateway();
        this.user1 = new User("johnnyappleseed@gmail.com", "Johnny", "johnny123");
        this.profile1 = new Profile(user1, gateway);

        this.user2 = new User("helloworld@gmail.com", "Hello", "world123");
        this.profile2 = new Profile(user2, gateway);
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetUser() {
        // sees if usernames and other elements of user matches that of the
        // user returned by getUser()
        assertEquals(user1.getUsername(), profile1.getUser().getUsername());
        assertNotSame(user2.getPassword(), profile1.getUser().getPassword());
        assertEquals(user2.getEmail(), profile2.getUser().getEmail());
    }

    public void testGetProfileFollow() {
        user3f = new FollowManager(profile1.getUser());
        assertNotSame(user3f, profile1.getFollowManager()); //shows same data types are being compared
        //shows the getter works
        userf = profile1.getFollowManager();
        userf.getFollowers().put("Username1", user2f);
        userf.getFollowing().put("Username2", user2f);
        user2f = profile2.getFollowManager();

        assertTrue(userf.getFollowers().containsKey("Username1"));
        assertTrue(userf.getFollowing().containsKey("Username2"));
        assertEquals(user2f, profile2.getFollowManager());
        assertNotSame(userf, profile2.getFollowManager()); //shows userf is not equal to user2f
    }

    public void testGetRoutines() {
        //shows that it matches the elements of the
        // hard coded routines
        assertEquals("My routine", profile1.getRoutines().get(0).getName());
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