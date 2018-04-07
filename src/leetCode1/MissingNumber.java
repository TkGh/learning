package leetCode1;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int cnt = nums.length;
        for (int i = 0; i < nums.length; i++) {
            cnt += i - nums[i];
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
        MissingNumber b = new MissingNumber();
        System.out.println(b.missingNumber(a));
    }
}
