import java.util.Stack;

public class QueuesUsingStack {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueuesUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    // enqueue
    public void add(int item) {
        first.push(item);
    }

    // dequeue
    public int remove() throws Exception {
        if (first.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    // peek front
    public int peek() throws Exception {
        if (first.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    // =========================
    // MAIN METHOD FOR TESTING
    // =========================
    public static void main(String[] args) {

        try {

            QueuesUsingStack queue = new QueuesUsingStack();

            System.out.println("Adding elements:");
            queue.add(10);
            queue.add(20);
            queue.add(30);
            queue.add(40);

            System.out.println("Front element: " + queue.peek());

            System.out.println("Removed: " + queue.remove());
            System.out.println("Removed: " + queue.remove());

            System.out.println("Front element after removals: " + queue.peek());

            System.out.println("Removed: " + queue.remove());
            System.out.println("Removed: " + queue.remove());

            System.out.println("Is queue empty? " + queue.isEmpty());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}