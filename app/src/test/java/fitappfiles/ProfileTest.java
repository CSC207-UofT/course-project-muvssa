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
    Routine routine1;
    Routine routine2;


    public void setUp() throws Exception {
        this.routine1 = new Routine("My routine", "A new routine");
        this.routine2 = new Routine("My routine2", "A new routine");

        Saveable gateway = new FirebaseGateway();
        this.user1 = new User("johnnyappleseed@gmail.com", "Johnny");
        this.profile1 = new Profile(user1, gateway);
        profile1.addRoutine(routine1);

        this.user2 = new User("helloworld@gmail.com", "Hello");
        this.profile2 = new Profile(user2, gateway);
        profile2.addRoutine(routine2);

        super.setUp();
    }

    public void testGetUser() {
        // sees if usernames and other elements of user matches that of the
        // user returned by getUser()
        assertEquals(user1.getUsername(), profile1.getUsername());
        assertEquals(user2.getEmail(), profile2.getEmail());
    }

    public void testGetProfileFollow() {
        user3f = new FollowManager(user1);
        assertNotSame(user3f, profile1.getFollowManager()); // shows same data types are being compared
        // shows the getter works
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
        // shows that it matches the elements of the
        // hard coded routines
        assertEquals(routine1, profile1.getRoutines().get(0));
        assertEquals(routine2, profile2.getRoutines().get(0));
    }

    public void testAddRoutine() {
        // shows that the element has been added by looking at
        // size and matching name
        profile2.addRoutine(new Routine("My routine3", "My new routine"));
        assertEquals("My routine3", profile2.getRoutines().get(1).getName());
        assertEquals(2, profile2.getRoutines().size());

    }
}