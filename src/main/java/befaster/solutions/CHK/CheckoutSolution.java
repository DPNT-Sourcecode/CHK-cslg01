package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> prices;
    private static final Map<Character, int[][]> oferteSpeciale;
    private static final Map<Character, Character> oferteGratis;
    private static final Map<Character, Integer> totalObiecteGratis;

    static {
        prices = new HashMap<>();
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);
        prices.put('E', 40);

        oferteSpeciale = new HashMap<>();
        oferteSpeciale.put('A', new int[][]{{5,200},{3, 130}});
        oferteSpeciale.put('B', new int[][]{{2, 45}});

        oferteGratis = new HashMap<>();
        oferteGratis.put('E', 'B');

        totalObiecteGratis = new HashMap<>();
        totalObiecteGratis.put('E', 2);
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
        int total = 0;
        for(Map.Entry<Character,Character> e : oferteGratis.entrySet()){
            char item = e.getKey();
            char freeitem = e.getValue();
            int totalItem = totalObiecteGratis.get(item);

            if (cerere.containsKey(item) && cerere.containsKey(freeitem)) {
                int numFreeItems = cerere.get(freeitem) / totalItem;
                int currentFreeItems = cerere.get(freeitem);
                cerere.put(freeitem, Math.max(0, currentFreeItems - numFreeItems));
            }
        }
        for (Map.Entry<Character, Integer> e : cerere.entrySet()) {
            char c = e.getKey();
            int count = e.getValue();
            int price = prices.get(c);

            if (oferteSpeciale.containsKey(c)) {
                int[][] offers = oferteSpeciale.get(c);
                for (int[] offer : offers) {
                    int offerCount = offer[0];
                    int offerPrice = offer[1];

                    while (count >= offerCount) {
                        total += offerPrice;
                        count -= offerCount;
                    }
                }
            }
            total += count * price;
        }
        return total;
    }

    public static void main(String[] args) {
        CheckoutSolution solution = new CheckoutSolution();
        System.out.println(solution.checkout(args[0]));
    }
}




