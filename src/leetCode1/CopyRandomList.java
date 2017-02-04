package leetCode1;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

public class CopyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}
		// First iteration: copy every node and insert to the original list
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode copy = new RandomListNode(curr.label);
			copy.next = curr.next;
			curr.next = copy;
			curr = curr.next.next;
		}

		// Second iteration: build random pointer
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		// Third iteration: separate list into two.
		RandomListNode newHead = head.next;
		curr = head;
		RandomListNode newCurr = newHead;

		curr.next = curr.next.next;
		curr = curr.next;
		while (curr != null) {
			newCurr.next = curr.next;
			newCurr = newCurr.next;
			curr.next = curr.next.next;
			curr = curr.next;
		}
		return newHead;
	}

}