public class WeightedRepExercise {

        private double weight;

        /**
         * Entity class for weight of weight being used for the workout
         * @param weight The double referring to the weight being lifted
         */

        public WeightedRepExercise(double weight) {
                this.weight = weight;
        }

        /**
         * Returns the value of the weight as a string
         * @return weight as a string
         */
        public String getWeight() {
                return String.valueOf(weight);
        }
        }