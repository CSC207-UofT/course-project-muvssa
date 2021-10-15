public class TimedExercise extends Exercise{

    private int set_time;


    public TimedExercise(String name, int sets, int rest, String muscle, int set_time) {
        super(name, sets, rest, muscle);
        this.set_time = set_time;
    }

    public TimedExercise(TimedExercise other)
    {
        super(other);
        this.set_time = 0;
    }

    public String getSet_time() {
        return String.valueOf(set_time);
    }


    @Override
    public double getVolume() {
        return super.numSets * this.set_time;
    }
}