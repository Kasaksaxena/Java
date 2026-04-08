
import java.util.*;

// TreeNode
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Leetcode297 {

    static class Codec {

        // ===== SERIALIZE =====
        public List<String> serialize(TreeNode root) {
            List<String> list = new ArrayList<>();
            helper(root, list);
            return list;
        }

        private void helper(TreeNode root, List<String> list) {
            if (root == null) {
                list.add("null");
                System.out.println("Serialize: null");
                return;
            }

            System.out.println("Serialize: " + root.val);
            list.add(String.valueOf(root.val));

            helper(root.left, list);
            helper(root.right, list);
        }

        // ===== DESERIALIZE =====
        public TreeNode deserialize(List<String> list) {
            Collections.reverse(list);
            System.out.println("\nReversed List: " + list);
            return helper2(list);
        }

        private TreeNode helper2(List<String> list) {

            String val = list.remove(list.size() - 1);
            System.out.println("Reading: " + val);

            if (val.equals("null")) {
                System.out.println("→ return null");
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(val));
            System.out.println("Create node: " + root.val);

            root.left = helper2(list);
            root.right = helper2(list);

            System.out.println("Return node: " + root.val);
            return root;
        }
    }

    // ===== Build Sample Tree =====
    public static TreeNode buildTree() {
        /*
                1
               / \
              2   3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        TreeNode root = buildTree();

        Codec codec = new Codec();

        System.out.println("===== SERIALIZATION =====");
        List<String> serialized = codec.serialize(root);

        System.out.println("\nSerialized List:");
        System.out.println(serialized);

        System.out.println("\n===== DESERIALIZATION =====");
        TreeNode newRoot = codec.deserialize(serialized);

        System.out.println("\nTree reconstructed successfully!");
    }
}
