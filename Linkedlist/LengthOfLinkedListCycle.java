public class LengthOfLinkedListCycle {
    static class ListNode{
        int val;
        ListNode next;
    
        ListNode(int val){
         this.val = val;
    }
}

    public static int hasCycle(ListNode head){
        if(head == null || head.next == null){
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

        slow = slow.next;          // move 1 step
        fast = fast.next.next;     // move 2 steps

        if(slow == fast ){
            int length =0;
            ListNode temp = slow;
            do{
                temp =temp.next;
                length++;
            }while (temp!=slow);
            return length;
        }


    }
    return 0;
}
        public static void main(String[] args) {

        // Create nodes
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        // Connect nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        // Create cycle (uncomment to test cycle)
        // n4.next = n2;

        int result = hasCycle(n1);
        System.out.println("Cycle length: " + result);
    }
    
}
