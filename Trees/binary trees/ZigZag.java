import java.util.*;

public class ZigZag {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void zigzag(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // This flag controls the direction of the current level
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (leftToRight) {
                    // Normal addition to the end
                    level.add(node.val);
                } else {
                    // Add to the front to "reverse" the level
                    level.add(0, node.val); 
                }

                // We ALWAYS add children to the queue in the same order (Left then Right)
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            // Output the level
            System.out.println(level);

            // Flip the direction for the next level
             leftToRight = !(leftToRight);
        }
    }

    public static void main(String[] args) {
        // Creating a Sample Tree:
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("ZigZag Traversal:");
        zigzag(root);
        // Expected Output:
        // [1]
        // [3, 2]
        // [4, 5, 6, 7]
    }
}