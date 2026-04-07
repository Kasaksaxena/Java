import java.util.*;

// TreeNode
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BuildTreewithPreInorder {

    static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;

            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);

            // find root in inorder
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }

            // split arrays
            int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
            int[] leftIn  = Arrays.copyOfRange(inorder, 0, index);

            int[] rightPre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
            int[] rightIn  = Arrays.copyOfRange(inorder, index + 1, inorder.length);

            root.left = buildTree(leftPre, leftIn);
            root.right = buildTree(rightPre, rightIn);

            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        Solution obj = new Solution();
        TreeNode root = obj.buildTree(preorder, inorder);

        System.out.println("Tree constructed!");
    }
}
