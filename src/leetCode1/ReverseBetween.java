package leetCode1;

public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		if (m == n) {
			return head;
		}

		int mid = (m + n) / 2;
		int currPos = 1;
		ListNode curr = head;
		ListNode fakeHead = new ListNode(0);
		ListNode prev = fakeHead;// the latest node before m.
		fakeHead.next = head;

		while (curr != null && currPos != m) {
			currPos++;
			prev = curr;
			curr = curr.next;
		}

		ListNode leftHelper = null;// help reverse left list.
		ListNode next = null;
		ListNode leftHead = null;
		ListNode leftTail = curr;
		while (curr != null & currPos <= mid) {
			next = curr.next;
			curr.next = leftHelper;
			leftHelper = curr;
			leftHead = curr;
			curr = next;
			currPos++;
		}

		ListNode rightHelper = null;// help reverse right list.
		ListNode rightHead = null;
		ListNode rightTail = curr;
		while (curr != null && currPos <= n) {
			next = curr.next;
			curr.next = rightHelper;
			rightHelper = curr;
			rightHead = curr;
			curr = next;
			currPos++;
		}

		prev.next = rightHead;
		rightTail.next = leftHead;
		leftTail.next = curr;

		return fakeHead.next;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		// ListNode b = new ListNode(3);
		// ListNode d = new ListNode(4);
		// ListNode g = new ListNode(5);
		// ListNode h = new ListNode(6);
		head.next = a;
		// a.next = b;
		// b.next = d;
		// d.next = g;
		// g.next = h;
		ReverseBetween c = new ReverseBetween();

		ListNode res = c.reverseBetween(head, 1, 2);
		int[] aa = new int[20];
		int count = 0;
		for (int i = 0; i < aa.length && res != null; i++) {
			aa[i] = res.val;
			res = res.next;
		}

		for (int f : aa) {
			count++;
			System.out.print(f);
			if (count % 10 == 0) {
				System.out.println();
			}
		}
	}
}
