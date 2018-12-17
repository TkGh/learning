package leetCode1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> cache = new HashSet<>();
        for (int num : G) {
            cache.add(num);
        }

        int res = 0;

        ListNode curr = head;
        int cnt = 0;
        while (curr != null) {
            if (cache.contains(curr.val)) {
                cnt++;
            } else {
                if (cnt != 0) res++;
                cnt = 0;
            }
            curr = curr.next;
        }

        return cnt == 0 ? res : res + 1;
    }
}
