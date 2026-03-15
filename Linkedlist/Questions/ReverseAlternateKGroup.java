public class ReverseAlternateKGroup {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        
    }
    public static ListNode reverseAlternateKGroup(ListNode head , int k){
        if( head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevgrpend = dummy;
        boolean reverse = true;// toggle between reverse and skip
        while (true) { 
            // check for k 
            ListNode kth = prevgrpend;
            for(int i = 0; i< k && kth !=null;i++){
                kth = kth.next;
            }
            if(kth == null) break;
            ListNode currgrpstart = prevgrpend.next;
            ListNode nextgrpstart = kth.next;


            //reverse 
            if(reverse){
                ListNode prev = nextgrpstart;
                ListNode current = currgrpstart;
            
            while( current != nextgrpstart){
                ListNode temp = current.next; 
                current.next = prev;
                prev =  current;
                current = temp;
            }
            //Connect reversed group
            prevgrpend.next = kth;
            prevgrpend = currgrpstart;

            
        } else{
            prevgrpend = kth ;
        }
         // Toggle reverse/skip

        reverse = !reverse;

    }
            return dummy.next;
 
}
public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
 public static void main(String[] args) {

        // Create list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Before:");
        display(head);

        head = reverseAlternateKGroup(head, 2);
        System.out.println("After:");
        display(head);

          
    }
}
    

