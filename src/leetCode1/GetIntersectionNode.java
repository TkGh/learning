package leetCode1;

public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode currA = headA;
		ListNode currB = headB;

		ListNode tailA = null;
		ListNode tailB = null;

		while (true) {
			if (currA == null) {
				currA = headB;
			}

			if (currB == null) {
				currB = headA;
			}

			if (currA.next == null) {
				tailA = currA;
			}

			if (currB.next == null) {
				tailB = currB;
			}

			if (tailA != null && tailB != null && tailA != tailB) {
				return null;
			}

			if (currA == currB) {
				return currA;
			}

			currA = currA.next;
			currB = currB.next;
		}
	}
}
