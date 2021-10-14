import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeeklySchedule {
    private final Map<DayOfWeek, Workout> weeklySchedule;

    /**
     * Constructor that maps all the days of the week to null (representing rest days)
     */
    public WeeklySchedule() {
        weeklySchedule = new HashMap<>(7);
        for (DayOfWeek day : DayOfWeek.values()) {
            weeklySchedule.put(day, null);
        }
    }

    /**
     * Constructor that maps a given day of the week to a given workout and the rest of the
     * days null (representing rest days)
     *
     * @param dayOfWeek specific day of the week to map a workout to
     * @param workout   workout to put to a day of the week
     */
    public WeeklySchedule(DayOfWeek dayOfWeek, Workout workout) {
        this();
        weeklySchedule.put(dayOfWeek, workout);
    }

    /**
     * Constructor that maps workouts in a given routine from a certain start day
     *
     * @param routine  a routine that contains workouts to be put into the weekly schedule
     * @param startDay the day to start the workouts from the routine in a week
     */
    public WeeklySchedule(Routine routine, DayOfWeek startDay) {
        this();

        ArrayList<Workout> workouts = routine.getWorkouts();
        for (int i = 0; i < workouts.size(); i++) {
            weeklySchedule.put(startDay.plus(i), workouts.get(i));
        }
    }

    /**
     * Constructor that maps workouts in a given routine starting Monday
     *
     * @param routine a routine that contains workouts to be put into the weekly schedule
     */
    public WeeklySchedule(Routine routine) {
        this(routine, DayOfWeek.MONDAY);
    }

    /**
     * Gets the current weekly schedule as a Map
     *
     * @return a map of the weekly schedule
     */
    public Map<DayOfWeek, Workout> getWeeklySchedule() {
        return weeklySchedule;
    }

    /**
     * Add a given workout to a specific day of the week
     *
     * @param day     day of the week to add workout to
     * @param workout workout to add to the day
     */
    public void addWorkout(DayOfWeek day, Workout workout) {
        weeklySchedule.put(day, workout);
    }

    /**
     * Remove a given workout from a specific day of the week
     *
     * @param day     day of the week to remove workout from
     * @param workout workout to remove from day
     */
    public void removeWorkout(DayOfWeek day, Workout workout) {
        weeklySchedule.remove(day, workout);
    }

    /**
     * Change workout for given day with new workout
     *
     * @param day     day of the week to replace workout
     * @param workout workout to replace current one with
     */
    public void changeWorkout(DayOfWeek day, Workout workout) {
        weeklySchedule.put(day, workout);
    }

    /**
     * Clear all workouts from the schedule by making them null (representing rest days)
     */
    public void clearSchedule() {
        weeklySchedule.replaceAll((k, v) -> null);  // makes each value in the map null
    }
}