package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> prices;
    private static final Map<Character, int[]> oferteSpeciale;

    static {
        prices = new HashMap<>();
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);

        oferteSpeciale = new HashMap<>();
        oferteSpeciale.put('A', new int[]{3, 130});
        oferteSpeciale.put('B', new int[]{2, 45});
    }
    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }
        Map<Character, Integer> cerere = new HashMap<>();

        for (char c :skus.toCharArray()) {
            if (!prices.containsKey(c)) {
                return -1;
            }
            cerere.put(c, cerere.getOrDefault(c, 0) + 1);

        }
        Integer total = 0;
        for (Map.Entry<Character, Integer> e : cerere.entrySet()) {
            char c = e.getKey();
            int count = e.getValue();
            int price = prices.get(c);

            if (oferteSpeciale.containsKey(c)) {
                int[] offer = oferteSpeciale.get(c);
                int offerCount = offer[0];
                int offerPrice = offer[1];

                int numOffers = count/offerCount;
                int remain = count % offerCount;

                total += numOffers * offerPrice + remain * price;
            } else {
                total += count * price;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        CheckoutSolution solution = new CheckoutSolution();
        System.out.println(solution.checkout(args[0]));
    }
}


