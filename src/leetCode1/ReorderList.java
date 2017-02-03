package leetCode1;

public class ReorderList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		ListNode a = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode b = new ListNode(7);

		l1.next = a;
		a.next = l2;
		l2.next = b;

		ListNode bb = ReorderList.reorderList(l1);
		int[] aa = new int[5];
		for (int i = 0; i < aa.length && bb != null; i++) {
			aa[i] = bb.val;
			bb = bb.next;
		}

		for (int e : aa) {
			System.out.println(e);
		}
	}

	public static ListNode reorderList(ListNode head) {

		int count = 1;
		ListNode curr = head;

		while (curr != null) {
			count++;
			curr = curr.next;
		}

		int halfCount = count / 2;
		ListNode newHead = null;
		count = 1;
		curr = head;
		while (curr != null) {
			if (count == halfCount) {
				newHead = curr.next;
				curr.next = null;
				break;
			}
			count++;
			curr = curr.next;
		}

		// reverse the lower half LinkedList
		ListNode prev = null;
		curr = newHead;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		// merge two LinkedList
		curr = head;
		ListNode curr2 = prev;
		while (curr != null && curr2 != null) {
			ListNode temp = curr2.next;
			curr2.next = curr.next;
			curr.next = curr2;
			curr = curr2.next;
			curr2 = temp;

		}
		return head;

	}
}
