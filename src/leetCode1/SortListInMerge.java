package leetCode1;

public class SortListInMerge {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(-3);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(4);

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

	// 归并排序
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		int count = 0;
		ListNode temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		int middle = count / 2;

		ListNode l = head, r = null;
		ListNode p2 = head;
		int countHalf = 0;
		while (p2 != null) {
			countHalf++;
			ListNode next = p2.next;

			if (countHalf == middle) {
				p2.next = null;
				r = next;
			}
			p2 = next;
		}

		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);

		ListNode merged = mergeTwoLists(h1, h2);

		return merged;

	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fake = new ListNode(0);
		fake.next = l1;
		ListNode pre = fake;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				l1 = l1.next;
			} else {
				ListNode next = l2.next;
				l2.next = pre.next;
				pre.next = l2;
				l2 = next;
			}
			pre = pre.next;
		}

		if (l2 != null) {
			pre.next = l2;

		}

		return fake.next;
	}
}
