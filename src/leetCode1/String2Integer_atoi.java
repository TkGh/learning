package leetCode1;

public class String2Integer_atoi {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        //Discard all leading whitespaces:
        int index = 0;
        char[] chars = str.toCharArray();
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }

        //Get the sign of number:
        int sign = 1;
        if (index < chars.length && (chars[index] == '+' || chars[index] == '-')) {
            sign = -(chars[index++] - ',');
        }

        //Get the number and check whether it's overflow:
        int start = index;
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9') {
            index++;
        }

        if (index == start) {
            return 0;
        }
        if (absLarger(str.substring(start, index), String.valueOf(Integer.MAX_VALUE))) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            return sign * (new Integer(str.substring(start, index)));
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
        String test = "  1095502006p8";
        System.out.println(new String2Integer_atoi().myAtoi(test));
    }
}


/*
 Time limit exceeded solution
 */

//class Solution {
//    public int myAtoi(String str) {
//        if (str == null) {
//            return 0;
//        }
//
//        if (!str.matches("\\p{Space}*[-|\\+]?\\d+.*")) {
//            return 0;
//        }
//
//        String regex = "-?\\d+";
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(str);
//
//        String res = null;
//        if (m.find()) {
//            res = m.group();
//        }
//
//        if (res.matches("\\d+")) {
//            return absLarger(res, String.valueOf(Integer.MAX_VALUE)) ? Integer.MAX_VALUE : new Integer(res);
//        } else {
//            return absLarger(res, String.valueOf(Integer.MIN_VALUE)) ? Integer.MIN_VALUE : new Integer(res);
//        }
//    }
//
//    private boolean absLarger(String str1, String str2) {
//        if (str1.length() < str2.length()) {
//            return false;
//        } else if (str1.length() > str2.length()) {
//            return true;
//        }
//
//        char[] chars1 = str1.toCharArray();
//        char[] chars2 = str2.toCharArray();
//
//        int index = 0;
//        while (index <= str1.length()) {
//            if (chars1[index] > chars2[index]) {
//                return true;
//            }
//        }
//        return false;
//
//    }
//}