package leetCode1;

import java.util.*;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        //eliminate some corner cases:
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        if (k == 0) {
            return false;
        }

        k = k < 0 ? -k : k;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (map.containsKey(sum) && i - map.get(sum) >= 1) {
                return true;
            }
            map.put(sum, i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 0};
        if (new ContinuousSubarraySum().checkSubarraySum(test, -1)) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
    }
}
