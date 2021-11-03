package fitappfiles;

public class WeightedRepExercise extends RepExercise{

        private final double weight;

        public WeightedRepExercise(String name, int sets, int rest, String muscle, int numRep, double weight) {
                super(name, sets, rest, muscle, numRep);
                this.weight = weight;
        }

        /**
         * Creates another WeightedRepExercise given another
         * @param other - another
         */
        public WeightedRepExercise(WeightedRepExercise other)
        {
                super(other);
                this.weight = other.weight;
        }
        public String getWeight() {
                return String.valueOf(weight);
        }
}