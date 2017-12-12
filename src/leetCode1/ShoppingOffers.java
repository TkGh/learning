package leetCode1;

import java.util.*;

public class ShoppingOffers {
    private HashMap<List<Integer>, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //Initiate dp: When buy nothing, you need to pay 0.
        List<Integer> init = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            init.add(0);
        }
        dp.put(init, 0);

        return helper(price, special, needs);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }

        int min = Integer.MAX_VALUE;
        for (List<Integer> s : special) {
            boolean exceed = false;
            List<Integer> needsCp = new ArrayList<>(needs);
            for (int i = 0; i < s.size() - 1; i++) {
                needsCp.set(i, needsCp.get(i) - s.get(i));
                if (needsCp.get(i) < 0) {
                    exceed = true;
                    break;
                }
            }
            if (!exceed) {
                min = Math.min(min, s.get(s.size() - 1) + helper(price, special, needsCp));
            }
        }

        int noSpecial = 0;
        for (int i = 0; i < needs.size(); i++) {
            noSpecial += needs.get(i) * price.get(i);
        }
        min = Math.min(min, noSpecial);

        dp.put(needs, min);
        return min;
    }
}
