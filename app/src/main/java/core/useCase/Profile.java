package core.useCase;


import core.entity.User;

public class Profile {

    private final User user;
    private final WeeklySchedule weeklySchedule;

    /**
     * Creates the main profile for one user
     * @param name this is the User's username
     * @param password this is the User's password
     * @param email this is the User's email
     */
    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.weeklySchedule = new WeeklySchedule();
    }

    /**
     * gets the User who owns the profile
     * @return a User class
     */
    public User getUser() {
        return user;

    }

    /**
     * returns the User's weekly Schedule
     * @return the WeeklySchedule class
     */
    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }


}
