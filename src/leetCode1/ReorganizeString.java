package leetCode1;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int n = S.length();
        int[] cnt = new int[128];
        char mc = 'a';
        for (char c : S.toCharArray()) {
            cnt[c]++;
            mc = (cnt[c] > cnt[mc]) ? c : mc;
        }
        if (cnt[mc] == 1) {
            return S;
        }
        if (n - cnt[mc] <= cnt[mc] - 2) {
            return "";
        }
        StringBuilder[] sb = new StringBuilder[cnt[mc]];
        for (int i = 0; i < sb.length; i ++) {
            sb[i] = new StringBuilder();
            sb[i].append(mc);
        }
        int k = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            while (c != mc && cnt[c] > 0) {
                sb[k++].append(c);
                cnt[c]--;
                k %= sb.length;
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
