package leetCode1;

import java.util.*;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1) {

            return nums1;
        }
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[nums2.length - 1], -1);
        for (int index = nums2.length - 2; index >= 0; index--) {
            int temp = nums2[index + 1];
            if (nums2[index] < temp) {
                map.put(nums2[index], temp);
            } else {
                while (nums2[index] > temp && map.containsKey(temp)) {
                    temp = map.get(temp);
                }
                map.put(nums2[index], temp);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
