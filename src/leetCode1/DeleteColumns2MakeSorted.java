package leetCode1;

public class DeleteColumns2MakeSorted {
    public int minDeletionSize(String[] A) {
        if (A.length == 1) return 0;

        int cnt = 0;
        for (int i = 0; i < A[0].length(); i++) {
            char cmp = 'a';
            for (int j = 0; j < A.length; j++) {
                if (A[j].charAt(i) < cmp) {
                    cnt++;
                    break;
                }
                cmp = A[j].charAt(i);
            }
        }

        return cnt;
    }
}
