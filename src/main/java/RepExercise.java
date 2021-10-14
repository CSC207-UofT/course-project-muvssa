public class RepExercise extends Exercise {

    private int numReps;

    public RepExercise(String name, int sets, int rest, String muscle, int numreps) {
        super(name,sets,rest,muscle);
        this.numReps = numreps;
    }

    public String getNumReps() {
        return String.valueOf(numReps);
    }


    @Override
    public double getVolume() {
        return this.numReps * super.numSets;
    }
}

