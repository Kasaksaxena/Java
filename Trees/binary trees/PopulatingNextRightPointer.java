// Definition for the Node structure
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(int _val) { val = _val; }
}

public class PopulatingNextRightPointer {
    
    public Node connect(Node root) {
        if (root == null) return null;

        // Start with the root level
        Node leftmost = root;

        // Level-by-level traversal
        while (leftmost.left != null) {
            Node head = leftmost;

            while (head != null) {
                // 1. Connect children of the same parent (2 -> 3)
                head.left.next = head.right;

                // 2. Connect children of different parents (5 -> 6)
                // We use the 'next' pointer we established in the PREVIOUS level
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Move the scout horizontally
                head = head.next;
            }

            // Move the level-starter down
            leftmost = leftmost.left;
        }

        return root;
    }

    public static void main(String[] args) {
        // Setup: Creating a simple 2-level tree
        //      1
        //    /   \
        //   2     3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        PopulatingNextRightPointer sol = new PopulatingNextRightPointer();
        sol.connect(root);

        // Verify: Check if 2 points to 3
        if (root.left.next != null) {
            System.out.println("Node " + root.left.val + " is now connected to Node " + root.left.next.val);
        }
    }
}