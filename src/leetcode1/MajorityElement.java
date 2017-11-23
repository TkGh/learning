package leetCode1;

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int majority = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt++;
                majority = nums[i];
            } else if (majority == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return majority;
    }

    public static void main(String[] args) {
        int[] a = {2, 11, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1};
        MajorityElement b = new MajorityElement();
        System.out.println(b.majorityElement(a));
    }
}
