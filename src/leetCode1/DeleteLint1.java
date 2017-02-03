package leetCode1;

public class DeleteLint1
{
	public ListNode solution(ListNode head, int n)
	{
		int pos = 0;
		ListNode current = head;
		ListNode previous = head;
		while (current != null)
		{
			pos++;
			current = current.next;
		}

		current = head;

		if (pos == n)
		{
			head = head.next;
			return head;
		}

		int i = 1;
		while (i < pos + 1 - n)
		{
			previous = current;
			current = current.next;
			i++;

		}

		previous.next = current.next;

		return head;
	}
}
