public class PalindromeLinkedList {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next== null){
            return true;
        }
        ListNode slow = head;
        ListNode fast= head;

        while(fast != null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }

        ListNode mid = slow;
        ListNode secondhalf = reverse(mid);
        ListNode firsthalf = head;

        while(secondhalf!=null){
            if(firsthalf.val != secondhalf.val){
                return false;
                }
                firsthalf=firsthalf.next;
                secondhalf =secondhalf.next;
            
        }
        return true;
    }
    

    // Reverse helper function
    private static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
    
    

