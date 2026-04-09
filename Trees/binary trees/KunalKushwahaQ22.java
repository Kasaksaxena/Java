import java.util.*;

// TreeNode
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class KunalKushwahaQ22 {

    static class Solution {

        public boolean hasPath(TreeNode root, int[] arr) {
            if (root == null) return false;

            // try starting from this node
            if (dfs(root, arr, 0)) return true;

            // otherwise try left or right subtree
            return hasPath(root.left, arr) || hasPath(root.right, arr);
        }

        private boolean dfs(TreeNode node, int[] arr, int index) {

            if (node == null || index >= arr.length) return false;

            if (node.val != arr[index]) return false;

            // if last element matched
            if (index == arr.length - 1) return true;

            return dfs(node.left, arr, index + 1) ||
                   dfs(node.right, arr, index + 1);
        }
    }

    // ===== Build Sample Tree =====
    public static TreeNode buildTree() {
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();
        int[] arr = {2, 5};

        Solution obj = new Solution();
        boolean result = obj.hasPath(root, arr);

        System.out.println("Path exists: " + result);
    }
}