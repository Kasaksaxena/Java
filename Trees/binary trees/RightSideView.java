import java.util.*;

public class RightSideView {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> getRightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // The Queue is the engine of BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Take a snapshot of the current level size
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // Logic: If this is the LAST element of the current level row
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                
                // Add children to the queue for the NEXT level
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Build the tree from your image:
        //      1
        //     / \
        //    2   3
        //   /
        //  4
        // /
        // 5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        List<Integer> view = getRightSideView(root);
        
        System.out.println("Right Side View: " + view); 
        // Expected Output: [1, 3, 4, 5]
    }
}