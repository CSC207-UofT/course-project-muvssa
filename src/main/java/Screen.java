import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Screen {
    private final Profile profile;

    /**
     * Is a very temporary UI for the user to see what they are interacting with
     *
     * @param profile takes in another profile
     */
    public Screen(Profile profile) {
        this.profile = profile;
    }

    /**
     * Displays a profile's followers to the screen
     */
    public void showFollowers() {
        System.out.println(profile.getUser().getUsername() + "'s followers are:");
        for (Object key : profile.getProfileFollow().getFollowers().keySet()) {
            System.out.println(key);
        }
        System.out.println();
    }

    /**
     * Displays a list of people the profile is following
     */
    public void showFollowing() {
        System.out.println(profile.getUser().getUsername() + " is following:");
        for (Object key : profile.getProfileFollow().getFollowing().keySet()) {
            System.out.println(key);
        }
        System.out.println();
    }

    /**
     * Displays information of the user associated with the profile
     */
    public void showUserInfo() {
        System.out.print("Username" + profile.getUser().getUsername());
        System.out.print("Email" + profile.getUser().getEmail());
        System.out.print("Password" + profile.getUser().getPassword());
        System.out.println();
    }

    /**
     * Displays the schedule from Monday-Sunday of the profiles workouts
     */
    public void showSchedule() {
        WeeklySchedule schedule = profile.getWeeklySchedule();

        System.out.println("------- Weekly Schedule for " + profile.getUser().getUsername() + " -------");
        for (DayOfWeek day : DayOfWeek.values()) {

            String dayOfWeek = day.getDisplayName(TextStyle.FULL, Locale.CANADA);
            Workout workout = schedule.getWorkout(day);

            String activityName;
            if (workout != null) {
                activityName = workout.getName();
            } else {    // workout is null
                activityName = "Rest";
            }

            System.out.printf("%-9s ->  %s\n", dayOfWeek, activityName);
        }
        System.out.println();

    }

    /**
     * Displays a post given by a post number of the profile
     *
     * @param postNumb post number for the post wanting to be displayed
     */
    public void showPost(int postNumb) {
        System.out.println("------- Posts for " + profile.getUser().getUsername() + " -------");

        Post post = profile.getProfilePosts().getPost(postNumb);
        System.out.println("Post workout: " + post.getWorkout().getName());
        System.out.println("Content of Post: " + post.getContent());
        System.out.println();
    }

}
