package leetCode1;

public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }


        //get the sign, Reverse the number and discard the leading 0:
        int sign = 1;
        StringBuffer sb = new StringBuffer();
        String res = "";
        while (x != 0 && x % 10 == 0) {
            x /= 10;
        }
        sb.append(x);
        if (x < 0) {
            sign = -1;
            int size = sb.length();
            res = sb.reverse().substring(0, size - 1);
        } else {
            res = sb.reverse().toString();
        }

        //Ensure the reversed number is not overflow:
        if (absLarger(res, String.valueOf(Integer.MAX_VALUE))) {
            return 0;
        } else {
            return sign * new Integer(res);
        }

    }

    private boolean absLarger(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        } else if (str1.length() > str2.length()) {
            return true;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int index = 0;
        while (index < str1.length()) {
            if (chars1[index] > chars2[index]) {
                return true;
            } else if (chars1[index] < chars2[index]) {
                return false;
            }
            index++;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }


}
