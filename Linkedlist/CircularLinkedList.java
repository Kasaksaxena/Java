public class CircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size;

    // ----------------------------
    // Insert at Last
    // ----------------------------
    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;   // points to itself
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }

        size++;
    }

    // ----------------------------
    // Display (using do-while)
    // ----------------------------
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // ----------------------------
    // Delete by value
    // ----------------------------
    public void delete(int value) {

        if (head == null) return;

        Node current = head;
        Node previous = tail;

        do {
            if (current.data == value) {

                // If only one node
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                }

                // If deleting head
                else if (current == head) {
                    head = head.next;
                    tail.next = head;
                }

                // If deleting tail
                else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                }

                // Middle node
                else {
                    previous.next = current.next;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Value not found");
    }

    // ----------------------------
    // Main
    // ----------------------------
    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();

        list.delete(10);  // delete head
        list.display();

        list.delete(40);  // delete tail
        list.display();
    }
}
