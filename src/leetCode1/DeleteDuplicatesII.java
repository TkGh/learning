package leetCode1;

import java.util.*;

public class DeleteDuplicatesII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (curr != null) {
			if (map.containsKey(curr.val)) {
				int freq = map.get(curr.val);
				map.put(curr.val, freq + 1);
				curr = curr.next;
			} else {
				map.put(curr.val, 1);
				curr = curr.next;
			}
		}

		ListNode tempHead = new ListNode(0);
		ListNode prev = tempHead;
		tempHead.next = head;
		curr = head;
		while (curr != null) {
			if (map.get(curr.val) > 1) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}

		return tempHead.next;

	}

	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(2);
		ListNode d = new ListNode(1);
		a.next = b;
		b.next = d;
		DeleteDuplicatesII c = new DeleteDuplicatesII();

		ListNode res = c.deleteDuplicates(a);
		int[] aa = new int[20];
		int count = 0;
		for (int i = 0; i < aa.length && res != null; i++) {
			aa[i] = res.val;
			res = res.next;
		}

		for (int f : aa) {
			count++;
			System.out.print(f);
			if (count % 10 == 0) {
				System.out.println();
			}
		}
	}
}
