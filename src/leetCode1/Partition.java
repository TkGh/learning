package leetCode1;

public class Partition {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode leftCurr = left;
		ListNode rightCurr = right;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val < x) {
				ListNode next = curr.next;
				curr.next = null;
				leftCurr.next = curr;
				leftCurr = curr;
				curr = next;
			} else {
				ListNode next = curr.next;
				rightCurr.next = curr;
				rightCurr = curr;
				curr.next = null;
				curr = next;
			}
		}
		leftCurr.next = right.next;
		return left.next;
	}
}
