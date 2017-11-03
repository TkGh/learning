package leetCode1;

public class Roman2Integer {
    public int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }

        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c.equals('M')) {
                sum += 1000;
            }
            if (c.equals('D')) {
                sum += 500;
            }
            if (c.equals('C')) {
                sum += 100;
            }
            if (c.equals('L')) {
                sum += 50;
            }
            if (c.equals('X')) {
                sum += 10;
            }
            if (c.equals('V')) {
                sum += 5;
            }
            if (c.equals('I')) {
                sum += 1;
            }
        }
        return sum;
    }
}
