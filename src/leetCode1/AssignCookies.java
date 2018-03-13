package leetCode1;

import java.util.*;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (s[j] >= g[i]) {
                cnt++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] g = {1, 2}, s = {1, 2, 3};
        System.out.println(new AssignCookies().findContentChildren(g, s));
    }
}
