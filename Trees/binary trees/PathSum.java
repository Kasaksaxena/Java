public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;

        // leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);

        System.out.println(hasPathSum(root, 20)); // true
    }
}
