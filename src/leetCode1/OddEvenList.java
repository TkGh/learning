package leetCode1;

public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode prev = head;
		ListNode even = head.next;
		while (even != null && even.next != null) {
			ListNode odd = even.next;
			ListNode nextEven = odd.next;
			ListNode evenHead = prev.next;
			prev.next = odd;
			odd.next = evenHead;
			even.next = nextEven;
			prev = prev.next;
			even = nextEven;
		}

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
		OddEvenList c = new OddEvenList();

		ListNode res = c.oddEvenList(head);
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
