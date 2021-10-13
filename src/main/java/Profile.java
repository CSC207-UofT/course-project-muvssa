import java.util.HashMap;
import java.util.Map;

public class Profile {


    private User user;
    //private Schedule schedule;
    //private Location location;
    private Map<String, Profile> following;
    private Map<String, Profile> followers;


    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        //this.schedule = new Schedule ();
        //this.location = new Location();
        this.following = new HashMap<String, Profile>();
        this.followers = new HashMap<String, Profile>();
    }
     //getters
    public User getUser() {
        return user;
    }

    //public Schedule getSchedule() {
    //    return schedule;
    //}

    //public Location getLocation() {
    //    return location;
    //}

    public Map getFollowing() {
        return following;
    }

    //editors
    private void addFollower(Profile person){
        this.followers.put(person.user.getUsername(), person);

    }
    public void addToSchedule() {
        //empty
    }
    public void removeFromSchedule() {
        //empty
    }
    public void follow(Profile person){
        this.following.put(person.user.getUsername(), person);
        person.addFollower(this);

    }

    public void editLocation(String name, String address) {
        //empty
    }

    public void editUser(String password) {
        this.user.setPassword(password);
    }
}
