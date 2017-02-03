package leetCode1;

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode curr = head;
		java.util.HashMap<ListNode, Integer> map = new java.util.HashMap<ListNode, Integer>();
		map.put(head, 1);

		while (curr.next != null) {
			if (map.containsKey(curr.next)) {
				return true;
			}
			curr = curr.next;
			map.put(curr, 1);
		}
		return false;
	}

}
