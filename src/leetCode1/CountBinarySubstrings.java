package leetCode1;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null || s.equals("") || s.length() == 1) {
            return 0;
        }

        int prevL = 0, currL = 1;
        int count = 0;

        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                currL++;
            } else {
                prevL = currL;
                currL = 1;
            }
            if (prevL >= currL) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(new CountBinarySubstrings().countBinarySubstrings(s));
    }
}
