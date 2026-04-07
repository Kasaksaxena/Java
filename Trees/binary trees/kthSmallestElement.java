// TreeNode
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class kthSmallestElement {

    static class Solution {
        private int count = 0;

        public int kthSmallest(TreeNode root, int k) {
            return helper(root, k).val;
        }

        public TreeNode helper(TreeNode root, int k) {
            if (root == null) return null;

            // go left
            TreeNode left = helper(root.left, k);
            if (left != null) return left;

            // visit node
            count++;
            if (count == k) return root;

            // go right
            return helper(root.right, k);
        }
    }

    // Build BST
    public static TreeNode buildTree() {
        /*
                5
               / \
              3   7
             / \ / \
            2  4 6  8
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();

        Solution obj = new Solution();
        int k = 6;

        System.out.println("Kth Smallest: " + obj.kthSmallest(root, k));
    }
}