import java.time.DayOfWeek;

public class FitApp {
    public static void main (String[] args){

        // All temporary had codded inputs to show oyr skeleton works
        Profiles fitApp = new Profiles();
        fitApp.signUp("Bob","bob123", "bob@mgail.com");
        fitApp.signUp("Alex","me123", "alex@mgail.com");


        Profile profile = fitApp.loginToProfile("Bob","bob123");
        Profile searched = fitApp.search("Alex");
        profile.getProfileFollow().follow(searched.getProfileFollow());

        Screen screen = new Screen(profile);
        screen.showFollowing();

        Workout workout = new Workout("Chest", "a chest workout");
        WeightedRepExercise exercise = new WeightedRepExercise("Bench press", 2,
                20,"chest", 10,200);
        workout.addExercise(exercise);
        profile.getProfilePosts().addPost(workout,"Just did chest today!");

        screen.showPost(0);

        profile.getWeeklySchedule().addWorkout(DayOfWeek.FRIDAY,workout);

        screen.showSchedule();


    }
}
