package leetCode1;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head.next;

		ListNode leftHead = null;
		ListNode rightHead = null;

		ListNode leftCur = null;
		ListNode rightCur = null;

		while (curr != null) {
			if (curr.val <= head.val) {
				ListNode temp = curr.next;
				if (leftHead == null) {
					leftHead = curr;
				}

				if (leftCur == null) {
					leftCur = curr;
				} else {

					leftCur.next = curr;
					leftCur = curr;
				}
				curr = temp;

			} else if (curr.val > head.val) {
				ListNode temp = curr.next;
				if (rightHead == null) {
					rightHead = curr;
				}

				if (rightCur == null) {
					rightCur = curr;
				} else {
					rightCur.next = curr;
					rightCur = curr;
				}
				curr = temp;
			}
		}

		if (leftCur != null) {
			leftCur.next = null;
		}
		if (rightCur != null) {
			rightCur.next = null;
		}

		ListNode left = sortList(leftHead);
		ListNode right = sortList(rightHead);

		if (left != null) {
			ListNode newLeft = left;
			while (newLeft.next != null) {
				newLeft = newLeft.next;
			}
			newLeft.next = head;
			head.next = right;
		} else {
			left = head;
			head.next = right;
		}

		return left;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		// ListNode d = new ListNode(-3);
		// ListNode e = new ListNode(6);
		// ListNode f = new ListNode(4);

		l1.next = a;
		a.next = b;
		b.next = c;
		// c.next = d;
		// d.next = e;
		// e.next = f;

		SortList res = new SortList();
		ListNode bb = res.sortList(l1);
		int[] aa = new int[10];
		for (int i = 0; i < aa.length && bb != null; i++) {
			aa[i] = bb.val;
			bb = bb.next;
		}

		for (int h : aa) {
			System.out.println(h);
		}
	}
}
