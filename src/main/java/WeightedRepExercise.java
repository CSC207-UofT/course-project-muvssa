public class WeightedRepExercise extends RepExercise{

        private double weight;

        public WeightedRepExercise(String name, int sets, int rest, String muscle, int numrep, double weight) {
                super(name, sets, rest, muscle, numrep);
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