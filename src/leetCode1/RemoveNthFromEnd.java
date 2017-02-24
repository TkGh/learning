package leetCode1;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		ListNode curr = head;
		ListNode fakeHead = new ListNode(666);
		fakeHead.next = head;
		ListNode prev = fakeHead;
		int prevPos = n;

		while (curr != null) {
			if (prevPos <= 0) {
				prev = prev.next;
			}
			curr = curr.next;
			prevPos--;
		}

		prev.next = prev.next.next;

		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		// ListNode a = new ListNode(2);
		// ListNode b = new ListNode(3);
		// ListNode d = new ListNode(4);
		// ListNode g = new ListNode(5);
		// ListNode h = new ListNode(6);
		// head.next = a;
		// a.next = b;
		// b.next = d;
		// d.next = g;
		// g.next = h;
		RemoveNthFromEnd c = new RemoveNthFromEnd();

		ListNode res = c.removeNthFromEnd(head, 1);
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
