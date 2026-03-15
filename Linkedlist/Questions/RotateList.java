public class RotateList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode RotateList(ListNode head , int k){
        if (head == null || head.next == null || k == 0) return head;
        // find length
        ListNode tail = head;
        int length =1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        // STEP 2: Make circular list
        tail.next = head;

        // find new tail 
        int steps = length -(k % length);
        ListNode newtail = tail;
        while( steps > 0){
            newtail = newtail.next;
            steps--;
        }
        ListNode newHead = newtail.next;
        newtail.next = null;

        return newHead;





    }
        public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before:");
        display(head);

        head = RotateList(head, 2);

        System.out.println("After:");
        display(head);
    }

    
}
