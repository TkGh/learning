package leetCode1;

import java.util.Arrays;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 1) return new ListNode[]{root};

        ListNode[] res = new ListNode[k];
        res[0] = root;

        int cnt = 0;
        ListNode curr = root;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }

        curr = root;

        if (cnt < k) {
            for (int i = 0; i < cnt; i++) {
                res[i] = curr;
                ListNode tmp = curr.next;
                curr.next = null;
                curr = tmp;
            }
            return res;
        }

        int base = cnt / k;
        int remain = cnt % k;
        int[] lengths = new int[k];
        Arrays.fill(lengths, base);
        for (int i = 0; i < remain; i++) {
            lengths[i]++;
        }

        k = 1;
        for (int i = 0; i < lengths.length - 1; i++) {
            while (lengths[i] > 1) {
                curr = curr.next;
                lengths[i]--;
            }
            ListNode tmp = curr.next;
            curr.next = null;
            curr = tmp;
            res[k] = curr;
            k++;
        }

        return res;
    }
}
