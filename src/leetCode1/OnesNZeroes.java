package leetCode1;

public class OnesNZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length < 1) {
            return 0;
        }

        int[][] cnt = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = count(str, '0');
            int ones = count(str, '1');

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    cnt[i][j] = Math.max(cnt[i][j], cnt[i - zeros][j - ones] + 1);
                }
            }
        }

        return cnt[m][n];
    }

    //Count 1s and 0s in every str:
    private int count(String str, char tar) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == tar) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] ars) {
        String[] strs = {"10", "1", "0"};
        System.out.println(new OnesNZeroes().findMaxForm(strs, 1, 1));
    }
}

/**
 * Not Dp and it is TOO SLOW!!!!!!!!!!!!!!!!!!!!!!
 */
//class Solution{
//    private int res = 0;
//
//    public int findMaxForm(String[] strs, int m, int n) {
//        if (strs.length < 1) {
//            return 0;
//        }
//
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() > o2.length() ? 1 : (o1.length() == o2.length() ? 0 : -1);
//            }
//        });
//        helper(strs, 0, m, n, 0);
//        return res;
//    }
//
//    private void helper(String[] strs, int i, int m, int n, int cnt) {
//        if (i >= strs.length) {
//            return;
//        }
//
//        int zeros = count(strs[i], '0');
//        int ones = count(strs[i], '1');
//
//        helper(strs, i + 1, m, n, cnt);
//        if (m - zeros >= 0 && n - ones >= 0) {
//            m -= zeros;
//            n -= ones;
//            cnt++;
//        }
//        res = Math.max(res, cnt);
//        helper(strs, i + 1, m, n, cnt);
//
//    }
//
//
//    //Count 1s and 0s in every str:
//    private int count(String str, char tar) {
//        int cnt = 0;
//        for (char c : str.toCharArray()) {
//            if (c == tar) {
//                cnt++;
//            }
//        }
//
//        return cnt;
//    }
//}