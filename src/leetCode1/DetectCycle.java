package leetCode1;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. solve it without using extra space
 */
public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode prev = head;
		ListNode curr = head.next;
		int count = 0;

		while (curr != null) {
			curr = curr.next;
			count++;
			if (count % 2 == 1) {
				prev = prev.next;
				if (prev == curr) {
					break;
				}
			}
		}

		if (curr == null) {
			return null;
		}
		prev = head;
		while (prev != curr) {
			prev = prev.next;
			curr = curr.next;
		}

		return curr;
	}

	public static void main(String[] args) {
		DetectCycle res = new DetectCycle();
		ListNode head = new ListNode(1);
		ListNode tail = new ListNode(2);
		head.next = tail;
		tail.next = head;
		System.out.println(res.detectCycle(head).val);
	}

}
