import java.time.DayOfWeek;

public class Screen {
    private Profile profile;

    /**
     * Is a very temporary UI for the user to see what they are interacting with
     * @param profile
     */
    public Screen(Profile profile){
        this.profile = profile;

    }

    /**
     * a String representation of the Profile's followers
     */
    public void showFollowers(){
        System.out.println("A list of people following this profile");
        for(Object key: profile.getProfileFollower().keySet()) {
            System.out.println(key);
        }
    }

    /**
     * a String representation of who the Profile is following
     */
    public void showFollowing(){
        System.out.println("A list of people this profile is following:");
        for(Object key: profile.getProfileFollowing().keySet()){
            System.out.println(key);
        }
    }

    /**
     * a String representation of the Profile's User info
     */
    public void showUserInfo(){
        System.out.print("Username" + profile.getUser().getUsername());
        System.out.print("Email" + profile.getUser().getEmail());
        System.out.print("Password" + profile.getUser().getPassword());
    }

    /**
     * a String representation of the Profile's Schedule
     */
    public void showSchedule(){
        WeeklySchedule schedule = profile.getWeeklySchedule();

        for(Object key: schedule.getWeeklySchedule().keySet()) {

            System.out.println("Day of the week: " + key);
            Workout workout = schedule.getWeeklySchedule().get(key);
            System.out.println("Workout name: " + workout.getName());
        }

    }

    /**
     * a String representation of a post made by the Profile
     */
    public void showPost(int postNumb){
        Post post = profile.getProfilePosts().getPost(postNumb);
        System.out.println("Under Workout " + post.getWorkout().getName());
        System.out.println("Is this post: " + post.getContent());
    }

}
