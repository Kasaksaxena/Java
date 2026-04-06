

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ValidateBST {

    // ===== LC 98 =====
    static class ValidatebST {

        public boolean isValidBST(TreeNode root) {
            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean validate(TreeNode node, long min, long max) {
            if (node == null) return true;

            if (node.val <= min || node.val >= max) return false;

            return validate(node.left, min, node.val) &&
                   validate(node.right, node.val, max);
        }
    }

    // ===== Utility: Build Tree =====
    public static TreeNode buildTree() {
        /*
                5
               / \
              3   7
             / \   \
            2   4   8
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(8);

        return root;
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        TreeNode root = buildTree();

        ValidatebST obj = new ValidatebST();
        boolean result = obj.isValidBST(root);

        System.out.println("Is Valid BST: " + result);
    }
}
