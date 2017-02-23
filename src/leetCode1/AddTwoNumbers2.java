package leetCode1;

import java.util.*;

public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> sum1 = new ArrayList<Integer>();
		ListNode curr = l1;
		while (curr != null) {
			sum1.add(curr.val);
			curr = curr.next;
		}

		List<Integer> sum2 = new ArrayList<Integer>();
		curr = l2;
		while (curr != null) {
			sum2.add(curr.val);
			curr = curr.next;
		}

		ListNode head = null;
		int plus = 0;
		int index1 = sum1.size() - 1;
		int index2 = sum2.size() - 1;
		while (index1 >= 0 && index2 >= 0) {
			int val = (sum1.get(index1) + sum2.get(index2) + plus) % 10;
			plus = (sum1.get(index1) + sum2.get(index2) + plus) / 10;
			ListNode node = new ListNode(val);
			node.next = head;
			head = node;
			index1--;
			index2--;
		}

		if (index1 < 0) {
			while (index2 >= 0) {
				int val = (sum2.get(index2) + plus) % 10;
				plus = (sum2.get(index2) + plus) / 10;
				ListNode node = new ListNode(val);
				node.next = head;
				head = node;
				index2--;
			}
		}
		if (index2 < 0) {
			while (index1 >= 0) {
				int val = (sum1.get(index1) + plus) % 10;
				plus = (sum1.get(index1) + plus) / 10;
				ListNode node = new ListNode(val);
				node.next = head;
				head = node;
				index1--;
			}
		}

		if (plus == 1) {
			ListNode node = new ListNode(1);
			node.next = head;
			head = node;
		}

		return head;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode a = new ListNode(9);
		ListNode b = new ListNode(9);
		ListNode l2 = new ListNode(7);
		ListNode g = new ListNode(9);
		ListNode i = new ListNode(9);
		ListNode j = new ListNode(9);
		ListNode k = new ListNode(9);
		ListNode l = new ListNode(9);
		ListNode m = new ListNode(9);

		ListNode h = new ListNode(9);
		l1.next = a;
		a.next = b;
		b.next = g;
		h.next = i;
		i.next = j;
		j.next = k;
		k.next = l;
		l.next = m;

		// l2.next = g;
		g.next = h;
		AddTwoNumbers2 c = new AddTwoNumbers2();

		ListNode res = c.addTwoNumbers(l1, l2);
		int[] aa = new int[20];
		int count = 0;
		for (int v = 0; v < aa.length && res != null; v++) {
			aa[v] = res.val;
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
