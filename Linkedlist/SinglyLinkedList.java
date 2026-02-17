public class SinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    // ----------------------------
    // Insert at First  O(1)
    // ----------------------------
    public void insertFirst(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    // ----------------------------
    // Insert at Last O(1) if tail exists
    // ----------------------------
    public void insertLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // ----------------------------
    // Delete First O(1)
    // ----------------------------
    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
    }

    // ----------------------------
    // Delete Last O(n)
    // ----------------------------
    public void deleteLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node temp = head;

        // Traverse to second-last node
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;

        size--;
    }

    // ----------------------------
    // Display
    // ----------------------------
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // ----------------------------
    // Main Method
    // ----------------------------
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(10);
        list.insertFirst(5);
        list.insertLast(20);
        list.insertLast(30);

        list.display();  // 5 -> 10 -> 20 -> 30 -> null

        list.deleteFirst();
        list.display();  // 10 -> 20 -> 30 -> null

        list.deleteLast();
        list.display();  // 10 -> 20 -> null
    }
}
