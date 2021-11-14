package fitappfiles;

import com.example.fitappa.Model.Entity.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class FollowManager implements Serializable {


    private final User user;
    private final Map<String, FollowManager> following;
    private final Map<String, FollowManager> followers;

    /**
     * Hold all follow related commands within a profile
     * @param user take in the profiles' owner/User
     */
    public FollowManager(User user){
        this.user = user;
        this.following = new HashMap<>();
        this.followers = new HashMap<>();
    }

    /**
     * get who the User is following
     * @return returns a HashMap of who they are following
     */
    public Map<String, FollowManager> getFollowing() {
        return following;
    }

    /**
     * get who is following the User
     * @return returns a HashMap of who they are getting followed by
     */
    public Map<String, FollowManager> getFollowers() {
        return followers;
    }

    /**
     * private class that gives this class a follower
     * @param person A ProfileFollow class containing a User is receiving a follower
     */
    private void addFollower(FollowManager person){
        this.followers.put(user.getUsername(), person);

    }

    /**
     * Has this class follow another ProfileFollow
     * @param person A ProfileFollow class containing a User is receiving
     *              this class's User as a follower
     */
    public void follow(FollowManager person){
        this.following.put(person.user.getUsername(), person);
        person.addFollower(this);

    }

    public String followerCount(){
        return String.valueOf(this.followers.size());

    }
    public String followingCount(){
        return String.valueOf(this.following.size());

    }

}
