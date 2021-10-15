public class TimedExercise {

    private int set_time;
    private int break_time;

    /**
     * Entity class for the timing of the workouts
     * @param set_time represents the time that the set took
     * @param break_time represents the allocated rest time between sets
     */

    public TimedExercise(int set_time, int break_time) {
        // time that the break and set took in seconds
        this.set_time = set_time;
        this.break_time = break_time;
    }

    /**
     * Returns value of time that the set took as a string
     * @return set_time as a string
     */

    public String getSet_time() {
        return String.valueOf(set_time);
    }

    /**
     * Return the time that the break took as a string
     * @return value of break_time as a string
     */
    public String getBreak_time() {
        return String.valueOf(break_time);
    }


    }