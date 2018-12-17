package leetCode1;

public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null || (head.child == null && head.next == null)) return head;

        helper(head);

        return head;
    }

    private Node helper(Node node) {
        if (node.child == null && node.next == null) return node;

        while (node.next != null) {
            Node next = node.next;
            if (node.child != null) {
                Node tmp = node.next;
                node.next = node.child;
                node.child.prev = node;
                Node prev = helper(node.child);
                prev.next = tmp;
                tmp.prev = prev;
                node.child = null;
            }
            node = next;
        }

        if (node.child != null) {
            node.next = node.child;
            node.child.prev = node;
            Node prev = helper(node.child);
            node.child = null;
            return prev;
        }

        return node;
    }
}
