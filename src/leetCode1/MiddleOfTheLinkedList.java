package leetCode1;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode curr = head;
        ListNode next = head;

        while (next.next != null) {
            curr = curr.next;
            next = next.next;
            if (next.next == null) {
                return curr;
            }
            next = next.next;
        }

        return curr;
    }
}
