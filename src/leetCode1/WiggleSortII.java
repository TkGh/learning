package leetCode1;

import java.util.Random;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int length = nums.length;
        int median = findKthLargest(nums, length / 2);

        int indexLeft = 0;
        int i = 0;
        int indexRight = length - 1;

        while (i <= indexRight) {
            if (nums[newIndex(i, length)] > median) {
                exch(nums, newIndex(i++, length), newIndex(indexLeft++, length));
            } else if (nums[newIndex(i, length)] < median) {
                exch(nums, newIndex(i, length), newIndex(indexRight--, length));
            } else {
                i++;
            }
        }
    }

    private int newIndex(int oldIndex, int length) {
        return (oldIndex * 2 + 1) % (length | 1);
    }

    private int findKthLargest(int[] nums, int k) {
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

}
