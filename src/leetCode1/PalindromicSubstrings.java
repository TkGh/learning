package leetCode1;

public class PalindromicSubstrings {
    private int count = 0;

    public int countSubstrings(String s) {
        if (s.length() < 1) {
            return count;
        }

        char[] chars = s.toCharArray();
        count = s.length();

        for (int i = 0; i < chars.length; i++) {
            i = forward(chars, i);
        }
        return count;
    }

    private int forward(char[] chars, int index) {
        int l = index, r = index;
        while (r < chars.length - 1 && chars[r] == chars[r + 1]) {
            r++;
        }
        int temp = r;
        count += countDup(temp - l);
        while (r < chars.length - 1 && l > 0 && chars[r + 1] == chars[l - 1]) {
            l--;
            r++;
        }
        count += r - temp;
        return temp;
    }

    private int countDup(int n) {
        int sum = 0;
        while (n >= 1) {
            sum += n;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        String test = "aaa";
        System.out.println(new PalindromicSubstrings().countSubstrings(test));
    }
}
