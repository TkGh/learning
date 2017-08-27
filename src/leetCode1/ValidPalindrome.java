package leetCode1;

import java.util.regex.*;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == "") {
            return true;
        }

        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\w").matcher(s);
        while (m.find()) {
            sb.append(m.group().toLowerCase());
        }

        char[] chars = sb.toString().toCharArray();
        int index1 = 0;
        int index2 = chars.length - 1;
        while (index1 < chars.length && index2 >= 0) {
            if (index1 >= index2) {
                break;
            }
            if (chars[index1] != chars[index2]) {
                return false;
            }
            index1++;
            index2--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a Plan, A canal: Panama";
        String s2="race a car";
        String s3="0P";
        ValidPalindrome test = new ValidPalindrome();
        if (test.isPalindrome(s3)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
