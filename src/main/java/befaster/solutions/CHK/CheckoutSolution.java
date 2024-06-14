package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;

public class CheckoutSolution {
    public Integer checkout(String skus) {
//        private static final Map<Character, Integer> prices;
//        private static final Map<Character, int[]> oferteSpeciale;

//        static {
//            prices = new HashMap<>();
//            prices
//        }
        Integer total = 0;
        if (skus == null) {
            return -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        CheckoutSolution solution = new CheckoutSolution();
        System.out.println(solution.checkout(args[0]));
        System.out.println(args[0]);
    }
}

