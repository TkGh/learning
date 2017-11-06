package leetCode1;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }

        if (sb.toString().contains(B)) {
            return count;
        }
        if (sb.append(A).toString().contains(B)) {
            return ++count;
        }

        return -1;
    }

    public static void main(String[] args) {
        String A = "abcde";
        String B = "ea";
        System.out.println(new RepeatedStringMatch().repeatedStringMatch(A, B));
    }
}
