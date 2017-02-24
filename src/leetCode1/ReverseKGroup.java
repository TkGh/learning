package leetCode1;

public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakeHead = new ListNode(666);
		fakeHead.next = head;
		ListNode junc = fakeHead;
		ListNode curr = head;
		while (curr != null) {
			junc.next = swapHelper(curr, k);
			junc = curr;
			curr = curr.next;
		}

		return fakeHead.next;
	}

	private ListNode swapHelper(ListNode head, int k) {
		ListNode curr = head;
		int num = 1;
		while (num < k && curr.next != null) {
			curr = curr.next;
			num++;
		}

		if (num < k) {
			return head;
		}

		ListNode newHead = null;
		curr = head;
		num = 1;
		while (num <= k) {
			ListNode next = curr.next;
			curr.next = newHead;
			newHead = curr;
			curr = next;
			num++;
		}

		head.next = curr;

		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode g = new ListNode(5);
		ListNode h = new ListNode(6);
		head.next = a;
		a.next = b;
		b.next = d;
		d.next = g;
		g.next = h;
		ReverseKGroup c = new ReverseKGroup();

		ListNode res = c.reverseKGroup(head, 5);
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
