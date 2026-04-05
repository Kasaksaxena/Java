import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class SortedArrayToBST1 {

    // ================= LC 108 =================
    static class SortedArrayToBST {
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private TreeNode build(int[] nums, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;

            TreeNode root = new TreeNode(nums[mid]);

            root.left = build(nums, left, mid - 1);
            root.right = build(nums, mid + 1, right);

            return root;
        }
    }

    // ================= LC 226 =================
    static class InvertBinaryTree {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            // swap
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }

    // ================= Utility: Print Tree (Level Order) =================
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node == null) {
                    System.out.print("null ");
                    continue;
                }
                System.out.print(node.val + " ");
                q.offer(node.left);
                q.offer(node.right);
            }
            System.out.println();
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        // ===== Test LC 108 =====
        int[] nums = {-10, -3, 0, 5, 9};

        SortedArrayToBST obj108 = new SortedArrayToBST();
        TreeNode bstRoot = obj108.sortedArrayToBST(nums);

        System.out.println("BST from sorted array:");
        printLevelOrder(bstRoot);

        // ===== Test LC 226 =====
        InvertBinaryTree obj226 = new InvertBinaryTree();
        TreeNode inverted = obj226.invertTree(bstRoot);

        System.out.println("\nInverted Tree:");
        printLevelOrder(inverted);
    }
}