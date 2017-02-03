package leetCode1;

public class RotateRight {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		ListNode a = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode b = new ListNode(7);

		l1.next = a;
		a.next = l2;
		l2.next = b;

		RotateRight res = new RotateRight();
		ListNode bb = res.rotateRight(l1, 3);
		int[] aa = new int[5];
		for (int i = 0; i < aa.length && bb != null; i++) {
			aa[i] = bb.val;
			bb = bb.next;
		}

		for (int e : aa) {
			System.out.println(e);
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode tail = null;
		ListNode curr = head;
		int count = 1;

		while (curr.next != null) {
			curr = curr.next;
			count++;
		}
		tail = curr;

		if (k % count == 0) {
			return head;
		}
		k = k % count;

		curr = head;
		int count2 = 1;
		while (count2 < count - k) {
			curr = curr.next;
			count2++;
		}

		ListNode newHead = curr.next;
		curr.next = null;
		tail.next = head;

		return newHead;

	}
}
