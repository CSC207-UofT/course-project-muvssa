public class TimedExercise {

    private int set_time;
    private int break_time;

    public TimedExercise(int set_time, int break_time) {
        // time that the break and set took in seconds
        this.set_time = set_time;
        this.break_time = break_time;
    }

    public String getSet_time() {
        return String.valueOf(set_time);
    }

    public String getBreak_time() {
        return String.valueOf(break_time);
    }


    }