package leetCode1;

public class MergeTwoLists2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		ListNode a = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode b = new ListNode(7);

		l1.next = a;
		l2.next = b;

		MergeTwoLists res = new MergeTwoLists();
		ListNode bb = res.mergeTwoLists(l1, l2);
		int[] aa = new int[5];
		for (int i = 0; i < aa.length && bb != null; i++) {
			aa[i] = bb.val;
			bb = bb.next;
		}

		for (int e : aa) {
			System.out.println(e);
		}
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
