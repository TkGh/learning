package leetCode1;

import java.util.*;

//From Boyer Moore's alg:
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int tar1 = 0, tar2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tar1) {
                cnt1++;
            } else if (nums[i] == tar2) {
                cnt2++;
            } else if (cnt1 == 0) {
                tar1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                tar2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<>();

        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tar1) {
                cnt1++;
            } else if (nums[i] == tar2) {
                cnt2++;
            }
        }

        if (cnt1 > nums.length / 3) {
            res.add(tar1);
        }

        if (cnt2 > nums.length / 3) {
            res.add(tar2);
        }

        return res;
    }
}
