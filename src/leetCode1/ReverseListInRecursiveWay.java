package leetCode1;

public class ReverseListInRecursiveWay {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode temp = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return temp;
		}
	}
}
