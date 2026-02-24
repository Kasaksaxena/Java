public class SortListMergeExample {

    // Node definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Main merge sort function
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;   // base case
        }

        // Step 1: Find middle
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;   // break list into two halves

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Function to find middle node
    private static ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // slow stops before middle
    }

    // Merge two sorted linked lists
    private static ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // attach remaining nodes
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Helper method to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // 🔹 Putting nodes manually
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        // Linking nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("Original List:");
        printList(n1);

        ListNode sorted = sortList(n1);

        System.out.println("Sorted List:");
        printList(sorted);
    }
}