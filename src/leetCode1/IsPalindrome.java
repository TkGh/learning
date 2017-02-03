package leetCode1;

public class IsPalindrome {

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null) {
			return true;
		}

		// 鎵惧埌涓棿鐐�
		ListNode mid = head;
		ListNode end = head;
		int i = 0;

		while (end.next != null) {
			if (i % 2 == 0) {
				mid = mid.next;
			}
			i++;
			end = end.next;
		}

		// 鍙嶈浆鍚庡崐閮ㄩ摼琛�
		ListNode curr = mid;
		ListNode tempHead = null;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = tempHead;
			tempHead = curr;
			curr = temp;
		}

		// 姣旇緝鍓嶅崐閮ㄥ垎鍜屽悗鍗婇儴鍒嗭紝鐩稿悓鍒欎负鍥炴枃
		ListNode comp1 = head;
		ListNode comp2 = tempHead;
		while (comp1 != mid) {
			if (comp2.val != comp1.val) {
				i = 0;
				break;
			}
			comp2 = comp2.next;
			comp1 = comp1.next;
			i = 1;
		}

		// 鍥炲閾捐〃
		curr = tempHead;
		ListNode prev = null;
		while (curr != mid) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		mid.next = prev;

		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
}
