package leetCode1;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int index1 = 0, index2 = chars.length - 1;
        while ((index1 <= index2) && chars[index1] == chars[index2]) {
            index1++;
            index2--;
        }

        if (index1 >= index2) {
            return true;
        } else {
            return helper(s.substring(index1 + 1, index2 + 1)) || helper(s.substring(index1, index2));
        }
    }

    private boolean helper(String s) {
        int index1 = 0, index2 = s.length() - 1;
        while (index1 <= index2) {
            if (s.charAt(index1) == s.charAt(index2)) {
                index1++;
                index2--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        String s1 = "aba";
        if (new ValidPalindrome2().validPalindrome(s1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
