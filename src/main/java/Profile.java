import java.util.Map;

public class Profile {


    private User user;
    private ProfileFollow profileFollow;
    private WeeklySchedule weeklySchedule;
    private ProfilePosts profilePosts;




    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.profileFollow = new ProfileFollow(this.user);
        this.weeklySchedule = new WeeklySchedule();
        this.profilePosts = new ProfilePosts();
    }
    public User getUser() {
        return user;

    }
    public Map getProfileFollowing(){
        return profileFollow.getFollowing();
    }
    public Map getProfileFollower(){
        return profileFollow.getFollowers();
    }

    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }

    public ProfilePosts getProfilePosts(){
        return profilePosts;
    }

}
