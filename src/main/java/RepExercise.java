public class RepExercise extends Exercise {

    private int numReps;

    public RepExercise(String name, int sets, int rest, String muscle, int numreps) {
        super(name,sets,rest,muscle);
        this.numReps = numreps;
    }

    /**
     * Creates a RepExercise Object given another
     * @param other
     */
    public RepExercise(RepExercise other)
    {
        super(other);
        this.numReps = 0;
    }

    /**
     * Creates a RepExercise object given the name
     * @param name
     */
    public RepExercise(String name)
    {
        super(name);
        this.numReps = 0;
    }

    public String getNumReps() {
        return String.valueOf(numReps);
    }


    @Override
    public double getVolume() {
        return this.numReps * super.numSets;
    }
}

