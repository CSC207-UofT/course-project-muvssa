import java.util.HashMap;
import java.util.Map;
public class Profile {


    private final User user;
    private final  Map<String, Profile> following;
    private final Map<String, Profile> followers;
    //private final WorkoutTracker workoutTracker;
    //private final WeeklySchedule schedule


    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.following = new HashMap<String, Profile>();
        this.followers = new HashMap<String, Profile>();
        //this.workoutTracker = new WorkoutTracker();
        //this.schedule = new WeeklySchedule
    }
    public User getUser() {
        return user;
    }


    public Map getFollowing() {
        return following;
    }

    public Map getFollowers() {
        return followers;
    }

    private void addFollower(Profile person){
        this.followers.put(person.user.getUsername(), person);

    }

    public void follow(Profile person){
        this.following.put(person.user.getUsername(), person);
        person.addFollower(this);

    }


    public void editUser(String password) {
        this.user.setPassword(password);
    }
}
