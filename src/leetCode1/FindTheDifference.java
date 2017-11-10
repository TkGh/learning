package leetCode1;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int sum = 0;

        int index = 0;
        for (; index < t.length(); index++) {
            sum += t.charAt(index);
        }

        index = 0;
        for (; index < s.length(); index++) {
            sum -= s.charAt(index);
        }

        return (char) sum;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println(new FindTheDifference().findTheDifference(s, t));
    }
}
