public class LinkedList {
        // Node class
    static class Node{
        int value;
        Node next;

        Node(int value ){
            this.value = value;
            this.next = null;

        }

    }
    Node head;
    Node tail;
    int size;

    // Insert at end
    public void insertLast(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            tail = newNode;

        }else{
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void insertFirst( int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = head;
        }

        size ++;


    }
        // Display list
      public void display(){
        Node temp = head;
        while (temp!= null){
             System.out.println(temp.value + " ->");
             temp= temp.next;

        }
        System.out.println("null");
      }
          // Main method
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertFirst(5);

        list.display();
    }

}
