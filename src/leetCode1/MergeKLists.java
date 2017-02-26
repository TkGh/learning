package leetCode1;

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}

		int freq = 1;
		int size = lists.length - 1;
		while (size > 1) {
			size /= 2;
			freq++;
		}
		int i = 1;
		int interval = 1;
		while (i <= freq) {
			for (int j = 0; j < lists.length; j += 2 * interval) {
				if (j + interval < lists.length) {
					lists[j] = merge(lists[j], lists[j + interval]);
				}
			}
			interval *= 2;
			i++;
		}

		return lists[0];
	}

	private ListNode merge(ListNode head, ListNode head2) {
		if (head2 == null) {
			return head;
		}
		if (head == null) {
			return head2;
		}

		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pre = fake;

		while (head != null && head2 != null) {
			if (head.val <= head2.val) {
				head = head.next;
			} else {
				ListNode next = head2.next;
				head2.next = pre.next;
				pre.next = head2;
				head2 = next;
			}
			pre = pre.next;
		}

		if (head2 != null) {
			pre.next = head2;

		}
		return fake.next;
	}
}
