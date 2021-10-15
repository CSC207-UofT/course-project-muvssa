import java.util.Map;

public class Profile {


    private User user;
    private ProfileFollow profileFollow;
    private WeeklySchedule weeklySchedule;
    private ProfilePosts profilePosts;


    /**
     * Creates the main profile for one user
     * @param name this is the User's username
     * @param password this is the User's password
     * @param email this is the User's email
     */
    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.profileFollow = new ProfileFollow(this.user);
        this.weeklySchedule = new WeeklySchedule();
        this.profilePosts = new ProfilePosts();
    }

    /**
     * gets the User who owns the profile
     * @return a User class
     */
    public User getUser() {
        return user;

    }

    /**
     * gets who the User is following
     * @return returns a HashMap of people User is following
     */
    public Map getProfileFollowing(){
        return profileFollow.getFollowing();
    }

    /**
     * gets who the User's followers are
     * @return returns a HashMap of people who are following the User
     */
    public Map getProfileFollower(){
        return profileFollow.getFollowers();
    }

    /**
     * returns the User's weekly Schedule
     * @return the WeeklySchedule class
     */
    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }

    /**
     * Posts made by the User
     * @return the ProfilePosts class
     */
    public ProfilePosts getProfilePosts(){
        return profilePosts;
    }

}
