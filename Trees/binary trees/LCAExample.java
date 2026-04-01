public class LCAExample {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        // if both sides return non-null → this is LCA
        if (left != null && right != null) {
            return root;
        }

        // otherwise return non-null side
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        TreeNode p = root.left.left;  // 6
        TreeNode q = root.left.right; // 2

        TreeNode ans = LCA(root, p, q);
        System.out.println("LCA: " + ans.val); // 5
    }
}