package leetCode1;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode curr1 = l1;
		ListNode curr2 = l2;
		ListNode prev = curr1;
		int plus = 0;

		while (curr1.next != null && curr2 != null) {
			int temp = (curr1.val + curr2.val + plus) / 10;
			curr1.val = (curr1.val + curr2.val + plus) % 10;
			plus = temp;
			prev = curr1;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		if (curr2 != null) {
			curr1.next = curr2.next;
			int temp = (curr1.val + curr2.val + plus) / 10;
			curr1.val = (curr1.val + curr2.val + plus) % 10;
			plus = temp;
			prev = curr1;
			curr1 = curr1.next;
		}

		while (curr1 != null) {
			int temp = (curr1.val + plus) / 10;
			curr1.val = (curr1.val + plus) % 10;
			plus = temp;
			prev = curr1;
			curr1 = curr1.next;
		}
		if (plus != 0) {
			ListNode tail = new ListNode(plus);
			prev.next = tail;
		}

		return l1;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(1);
		ListNode b = new ListNode(8);
		// ListNode c = new ListNode(3);
		// ListNode d = new ListNode(6);
		// ListNode e = new ListNode(4);
		// // ListNode q = new ListNode(9);
		// ListNode w = new ListNode(9);
		// ListNode r = new ListNode(9);
		// ListNode t = new ListNode(9);
		// ListNode y = new ListNode(9);
		// ListNode u = new ListNode(9);

		// l2.next = d;
		// d.next = e;
		l1.next = b;
		// b.next = c;
		// // e.next = q;
		// q.next = w;
		// w.next = r;
		// r.next = t;
		// t.next = y;
		// y.next = u;

		AddTwoNumbers s = new AddTwoNumbers();
		ListNode res = s.addTwoNumbers(l1, l2);
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
