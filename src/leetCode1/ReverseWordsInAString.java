package leetCode1;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        int start = 0, end = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                end = i + 1;
                start = findStart(chars, i);
                sb.append(s.substring(start, end) + " ");
                i = start - 1;
            }
        }

        return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "";
    }

    private int findStart(char[] chars, int start) {
        int i = start - 1;
        for (; i >= 0; i--) {
            if (chars[i] == ' ') {
                break;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        System.out.print(new ReverseWordsInAString().reverseWords("aaa"));
        System.out.println("||||||");
    }
}
