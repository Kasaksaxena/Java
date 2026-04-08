import java.util.*;

// TreeNode
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Leetcode129 {

    static class Solution {

        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int current) {
            if (node == null) return 0;

            // build number
            current = current * 10 + node.val;

            // if leaf → return number
            if (node.left == null && node.right == null) {
                return current;
            }

            // sum from left and right
            int leftSum = dfs(node.left, current);
            int rightSum = dfs(node.right, current);

            return leftSum + rightSum;
        }
    }

    // ===== Build Example Tree =====
    public static TreeNode buildTree() {
        /*
                4
               / \
              9   0
             / \
            5   1
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        return root;
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        TreeNode root = buildTree();

        Solution obj = new Solution();
        int result = obj.sumNumbers(root);

        System.out.println("Sum of root-to-leaf numbers: " + result);
    }
}
