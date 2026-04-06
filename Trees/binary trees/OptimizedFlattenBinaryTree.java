import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class OptimizedFlattenBinaryTree {

    // ===== LC 114 Optimized =====
    static class FlattenBinaryTree {

        private TreeNode prev = null;

        public void flatten(TreeNode root) {
            if (root == null) return;

            // reverse preorder
            flatten(root.right);
            flatten(root.left);

            root.right = prev;
            root.left = null;

            prev = root;
        }
    }

    // ===== Utility =====
    public static void printList(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    // ===== Sample Tree =====
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        return root;
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        TreeNode root = buildTree();

        FlattenBinaryTree obj = new FlattenBinaryTree();
        obj.flatten(root);

        printList(root);
    }
}
