package leetCode1;

public class MergeTwoLists {
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
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val > l2.val) {
			ListNode temp = l2.next;
			l2.next = l1;
			l1 = l2;
			l2 = temp;
		}

		ListNode curr1 = l1;
		ListNode curr2 = l2;
		while (curr1.next != null && curr2 != null) {
			if (curr2.val >= curr1.val && curr2.val < curr1.next.val) {
				ListNode temp = curr2.next;
				curr2.next = curr1.next;
				curr1.next = curr2;
				curr2 = temp;
				curr1 = curr1.next;
			} else {
				curr1 = curr1.next;
			}

		}

		while (curr2 != null) {
			curr1.next = curr2;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		return l1;

	}
}
