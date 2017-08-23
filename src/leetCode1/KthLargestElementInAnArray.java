package leetCode1;

import java.util.*;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);//avoid the worst case.

        sort(nums, 0, nums.length - 1);

        return nums[k - 1];

    }

    //sort array in descending order:
    private void sort(int[] nums, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(nums, low, high);
        sort(nums, low, j - 1);
        sort(nums, j + 1, high);

    }

    private int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = arr[low];

        while (true) {
            while (less(v, arr[++i])) {
                if (i == high) {
                    break;
                }
            }

            while (less(arr[--j], v)) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, low, j);

        return j;
    }

    //Check if var1 is less than var2:
    private boolean less(int var1, int var2) {
        return var1 - var2 < 0 ? true : false;
    }

    //exchange the two value in arr:
    private void exch(int[] arr, int index1, int index2) {
        int tem = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tem;
    }

    //shuffle the array:
    private void shuffle(int a[]) {
        final Random random = new Random();

        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray test = new KthLargestElementInAnArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 32, 2, 5, 1};
        System.out.print(test.findKthLargest(nums, 2));
    }
}
