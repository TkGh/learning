package leetCode1;

/**
 * Given a linked list, determine if it has a cycle in it. solve it without
 * using extra space.
 */
public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode curr = head.next;
		ListNode prev = head;
		int interval = 0;

		while (curr != null) {
			if (curr == prev) {
				return true;
			}
			curr = curr.next;
			interval++;
			if (interval % 2 == 1) {
				prev = prev.next;
			}
		}

		return false;
	}

}
