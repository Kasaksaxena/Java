import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class FlattenBinaryTree1 {

    // ========== LC 114 ==========
    static class FlattenBinaryTree {

        public void flatten(TreeNode root) {
            if (root == null) return;

            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = null;
            root.right = left;

            // go to end of new right
            TreeNode curr = root;
            while (curr.right != null) {
                curr = curr.right;
            }

            curr.right = right;
        }
    }

    // ===== Utility: Print Right Skewed List =====
    public static void printList(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    // ===== Build sample tree =====
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

        System.out.println("Flattened Linked List:");
        printList(root);
    }
}