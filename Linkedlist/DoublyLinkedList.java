public class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size;

    // ----------------------------
    // Insert at First
    // ----------------------------
    public void insertFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    // ----------------------------
    // Insert at Last
    // ----------------------------
    public void insertLast(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    // ----------------------------
    // Insert After Given Value
    // ----------------------------
    public void insertAfter(int afterValue, int newValue) {

        Node temp = head;

        // Find the node
        while (temp != null && temp.data != afterValue) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        Node newNode = new Node(newValue);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;

        size++;
    }

    // ----------------------------
    // Delete a Node
    // ----------------------------
    public void delete(int value) {

        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        size--;
    }

    // ----------------------------
    // Display Forward
    // ----------------------------
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ----------------------------
    // Display Backward
    // ----------------------------
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // ----------------------------
    // Main Method
    // ----------------------------
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertAfter(20, 25);

        list.displayForward();
        list.displayBackward();

        list.delete(25);
        list.displayForward();
    }
}

