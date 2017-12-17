package leetCode1;

public class DeleteNEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        if (n < 1) return 0;

        if (n == 1) return nums[0];

        int size = 0;
        for (int num : nums) {
            size = Math.max(size, num);
        }
        size += 1;

        int[] points = new int[size];
        for (int num : nums) {
            points[num] += num;
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                sum1 = Math.max(sum1 + points[i], sum2);
            } else {
                sum2 = Math.max(sum1, sum2 + points[i]);
            }
        }


        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] test = {2,2,3,3,3,4};
        System.out.print(new DeleteNEarn().deleteAndEarn(test));
    }

}
