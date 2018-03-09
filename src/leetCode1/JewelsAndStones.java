package leetCode1;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J == "" || S == "") return 0;

        int[] jewels = new int[58];
        for (char c : J.toCharArray()) {
            jewels[c - 65]++;
        }

        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (jewels[c - 65] > 0) cnt++;
        }

        return cnt;
    }
}
