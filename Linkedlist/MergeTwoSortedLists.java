public class MergeTwoSortedLists  {

    static class ListNode{
        int value;
        ListNode next;

        ListNode(int value){
        this.value = value;
    }
}
 

public static ListNode mergeTwoLists(ListNode list1, ListNode list2){

    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;
    while(list1 != null && list2!= null){
        if(list1.value <= list2.value){
            tail.next = list1;
            list1 = list1.next;
        }
        else{
            tail.next = list2;
            list2 = list2.next;
        }
        tail = tail.next;

        

    }
    if(list1 != null){
        tail.next = list1;
        
    }
    else{
        tail.next = list2;
    }

    return dummy.next;
}
// 🔹 Display function
    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // List 1: 1 → 2 → 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // List 2: 1 → 3 → 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(list1, list2);

        display(result);
    }

    
}
