public class TimedExercise extends Exercise{

    private int set_time;


    public TimedExercise(String name, int sets, int rest, String muscle, int set_time) {
        super(name, sets, rest, muscle);
        this.set_time = set_time;
    }

    public String getSet_time() {
        return String.valueOf(set_time);
    }


    @Override
    public double getVolume() {
        return super.numSets * this.set_time;
    }
}