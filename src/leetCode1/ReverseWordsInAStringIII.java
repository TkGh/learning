package leetCode1;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            sb.append(" ");
        }
        String res = sb.substring(0, sb.length() - 1);
        return res;
    }

    public static void main(String[] args) {
        String s = "show me the md11ne``y";
        System.out.println(new ReverseWordsInAStringIII().reverseWords(s));
    }
}
