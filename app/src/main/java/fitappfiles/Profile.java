package fitappfiles;



public class Profile {

    private final User user;
    private final FollowManager followManager;
    private final WeeklySchedule weeklySchedule;
    private final Feed feed;


    /**
     * Creates the main profile for one user
     * @param name this is the User's username
     * @param password this is the User's password
     * @param email this is the User's email
     */
    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.followManager = new FollowManager(this.user);
        this.weeklySchedule = new WeeklySchedule();
        this.feed = new Feed();
    }

    /**
     * gets the User who owns the profile
     * @return a User class
     */
    public User getUser() {
        return user;

    }

    /**
     * gets who the User is following and who is following them
     * @return returns a HashMap of people User is following
     */
    public FollowManager getProfileFollow(){
        return followManager;
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
    public Feed getProfilePosts(){
        return feed;
    }

}
