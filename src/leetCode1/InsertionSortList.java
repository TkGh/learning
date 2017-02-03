package leetCode1;

public class InsertionSortList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		ListNode a = new ListNode(-222);
		ListNode l2 = new ListNode(5);
		ListNode b = new ListNode(7);

		l1.next = a;
		a.next = l2;
		l2.next = b;

		InsertionSortList res = new InsertionSortList();
		ListNode bb = res.insertionSortList(l1);
		int[] aa = new int[5];
		for (int i = 0; i < aa.length && bb != null; i++) {
			aa[i] = bb.val;
			bb = bb.next;
		}

		for (int e : aa) {
			System.out.println(e);
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head.next;
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode prev = fake;
		head.next = null;

		while (curr != null) {
			ListNode next = curr.next;
			ListNode temp = prev;

			while (temp.next != null) {
				if (curr.val < temp.next.val) {
					curr.next = temp.next;
					temp.next = curr;
					break;
				}
				temp = temp.next;
			}

			if (temp.next == null) {
				temp.next = curr;
				curr.next = null;
			}

			curr = next;
		}

		return prev.next;

	}
}
