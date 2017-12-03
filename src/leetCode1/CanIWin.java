package leetCode1;

import java.util.*;

public class CanIWin {
    private boolean[] used;
    private HashMap<Integer, Boolean> map;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;

        used = new boolean[maxChoosableInteger + 1];
        map = new HashMap<>();

        return helper(desiredTotal);
    }

    private boolean helper(int desireTotal) {
        if (desireTotal < 0) {
            return false;
        }

        int key = format();
        if (!map.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!helper(desireTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }

        return map.get(key);
    }

    private int format() {
        int key = 0;
        for (boolean bit : used) {
            key <<= 1;
            key |= bit ? 1 : 0;
        }

        return key;
    }
}
