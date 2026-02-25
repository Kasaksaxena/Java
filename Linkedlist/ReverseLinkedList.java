public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Iterative reverse
    public static ListNode reverseIterative(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;  // store next

            current.next = prev;           // reverse link

            prev = current;                // move prev forward
            current = next;                // move current forward
        }

        return prev;
    }

    // Recursive reverse
    public static ListNode reverseRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;  // base case
        }

        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating nodes
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        // Linking nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("Original:");
        printList(n1);

        // Iterative reverse
        ListNode reversed = reverseIterative(n1);

        System.out.println("Reversed (Iterative):");
        printList(reversed);
    }
}