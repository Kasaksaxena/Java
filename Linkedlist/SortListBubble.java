public class SortListBubble {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode bubbleSort(ListNode head){
        if(head == null   || head.next== null){
            return head;
        }

        boolean swapped;
        do{
            swapped = false;
            ListNode current = head;
            while( current.next != null){
                if(current.val > current.next.val){
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val= temp;

                    swapped = true;
                }
                current = current.next;
            }


        }while(swapped);
        return head;
    }
    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode sort = bubbleSort(n1);
        display(sort);


    
    
}
}
