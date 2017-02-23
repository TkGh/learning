package leetCode1;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head;
		ListNode fakeHead = new ListNode(666);
		ListNode tail = fakeHead;
		while (curr != null) {
				tail.next = swap(curr);
				tail = curr;
				curr=curr.next;
		}

		return fakeHead.next;
	}

	private ListNode swap(ListNode head) {
		if (head.next == null) {
			return head;
		}

		ListNode prev = head;
		head = head.next;
		ListNode next = head.next;
		head.next = prev;
		prev.next = next;
		return head;
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
		SwapPairs c = new SwapPairs();

		ListNode res = c.swapPairs(head);
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
