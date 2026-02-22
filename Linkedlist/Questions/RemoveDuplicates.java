public class RemoveDuplicates {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔹 ITERATIVE SOLUTION
    public static ListNode deleteDuplicatesIterative(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                // Skip duplicate
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // 🔹 RECURSIVE SOLUTION
    public static ListNode deleteDuplicatesRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicatesRecursive(head.next);

        if (head.val == head.next.val) {
            return head.next;
        }

        return head;
    }

    // 🔹 Display function
    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 🔹 Main method
    public static void main(String[] args) {

        // Creating list manually: 1 → 1 → 2 → 3 → 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        display(head);

        // Choose one solution:

        head = deleteDuplicatesIterative(head);
        // head = deleteDuplicatesRecursive(head);

        System.out.println("After Removing Duplicates:");
        display(head);
    }
}