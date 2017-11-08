package leetCode1;

import java.util.*;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) {
            if (!kinds.contains(candy)) {
                kinds.add(candy);
            }
            if (kinds.size() == candies.length / 2) {
                break;
            }
        }

        return kinds.size();
    }
}
