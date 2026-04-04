import java.util.LinkedList;
import java.util.Queue;

// 1. Standard Tree Node definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Mark if we found one of the targets at this level
                if (curr.val == x) foundX = true;
                if (curr.val == y) foundY = true;

                // Check for SIBLINGS (Same parent)
                // If they have the same parent, they are NOT cousins.
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)) {
                        return false; 
                    }
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            // After checking the whole level:
            if (foundX && foundY) return true; // Found both on same level (and not siblings)
            if (foundX || foundY) return false; // Found only one, so they are at different levels
        }

        return false;
    }

    public static void main(String[] args) {
        // Setup a tree:
        //      1
        //    /   \
        //   2     3
        //  /
        // 4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        CousinsInBinaryTree solution = new CousinsInBinaryTree();
        
        // Test Case: Are 4 and 3 cousins? 
        // 4 is depth 2, 3 is depth 1 -> Should be false
        System.out.println("Are 4 and 3 cousins? " + solution.isCousins(root, 4, 3));
        
        // Test Case: Let's add 5 under 3
        //      1
        //    /   \
        //   2     3
        //  /       \
        // 4         5
        root.right.right = new TreeNode(5);
        // Now 4 and 5 are at the same depth with different parents -> Should be true
        System.out.println("Are 4 and 5 cousins? " + solution.isCousins(root, 4, 5));
    }
}