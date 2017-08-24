package leetCode1;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int length = nums.length;

        //Check the length:
        if (length <= 0) {
            return "";
        } else if (length == 1) {
            return nums[0] + "";
        }

        //Sort array and add to StringBuffer:
        sort(nums, 0, length - 1);

        if (nums[0] == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (int num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }


    //Quick sort
    private void sort(int[] nums, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(nums, low, high);
        sort(nums, low, j - 1);
        sort(nums, j + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = nums[low];
        while (true) {
            while (prior(nums[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (prior(v, nums[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, low, j);
        return j;
    }

    //determine the number that should be put in answer prior.
    private boolean prior(int var1, int var2) {
        String s1 = "" + var1 + var2;
        String s2 = "" + var2 + var1;

        return s1.compareTo(s2) > 0 ? true : false;

    }

    private void exch(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {56565, 56};
        LargestNumber test = new LargestNumber();
        System.out.print(test.largestNumber(nums));
    }
}
