import java.util.HashMap;
import java.util.Map;
public class ProfileFollow {


    private final User user;
    private Map<String, ProfileFollow> following;
    private Map<String, ProfileFollow> followers;


    public ProfileFollow(User user){
        this.user = user;
        this.following = new HashMap<String, ProfileFollow>();
        this.followers = new HashMap<String, ProfileFollow>();
    }

    public Map getFollowing() {
        return following;
    }

    public Map getFollowers() {
        return followers;
    }

    private void addFollower(ProfileFollow person){
        this.followers.put(user.getUsername(), person);

    }

    public void follow(ProfileFollow person){
        this.following.put(user.getUsername(), person);
        person.addFollower(this);

    }

}
