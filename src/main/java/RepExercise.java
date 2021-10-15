public class RepExercise {

    private int numreps;

    /**
     * Entity class for the reps for each workout
     * @param numreps represents the reps needed for a workout
     */

    public RepExercise(int numreps) {
        this.numreps = numreps;
    }

    /**
     * Get the number of reps needed for an exercise
     * @return numreps as a string
     */
    public String getnumreps() {
        return String.valueOf(numreps);
    }

    }

