import java.util.HashMap;
import java.util.Map;
public class ProfileFollow {


    private final User user;
    private Map<String, ProfileFollow> following;
    private Map<String, ProfileFollow> followers;

    /**
     * Hold all follow related commands within a profile
     * @param user take in the profiles owner/User
     */
    public ProfileFollow(User user){
        this.user = user;
        this.following = new HashMap<String, ProfileFollow>();
        this.followers = new HashMap<String, ProfileFollow>();
    }

    /**
     * get who the User is following
     * @return returns a HashMap of who they are following
     */
    public Map getFollowing() {
        return following;
    }

    /**
     * get who is following the User
     * @return returns a HashMap of who they are getting followed by
     */
    public Map getFollowers() {
        return followers;
    }

    /**
     * private class that gives this class a follower
     * @param person A ProfileFollow class containing a User is receiving a follower
     */
    private void addFollower(ProfileFollow person){
        this.followers.put(user.getUsername(), person);

    }

    /**
     * Has this class follow another ProfileFollow
     * @param person A ProfileFollow class containing a User is receiving
     *              this class's User as a follower
     */
    public void follow(ProfileFollow person){
        this.following.put(user.getUsername(), person);
        person.addFollower(this);

    }

}
