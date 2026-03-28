
public class HeightDiameter {

    static class TreeNode{
        int val;
        TreeNode left , right;

        TreeNode(int val){
            this.val = val;

        }
    }

    static int diameter = 0;
    static int Height(TreeNode root){
        if (root == null) return 0;
        int left = Height(root.left);
        int right = Height(root.right);
        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left,right);
    }

    // balanced tree
    
    static int checkHeight(TreeNode root) {
    if (root == null) return 0;

    int left = checkHeight(root.left);
    if (left == -1) return -1;

    int right = checkHeight(root.right);
    if (right == -1) return -1;

    if (Math.abs(left - right) > 1) return -1;

    return 1 + Math.max(left, right);
}

static boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
}

public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(Height(root));
        System.out.println(checkHeight(root));

        System.out.print(isBalanced(root));

    }
}
