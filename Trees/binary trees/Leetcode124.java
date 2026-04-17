class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}


public class Leetcode124 {
    
    private static int maxsum = Integer.MIN_VALUE;

    public  static int MaxPathsum(TreeNode root){
        helper(root);
        return maxsum;
    }

    public static  int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0 , helper(root.right));

        int currentval = left + right + root.val;

        maxsum = Math.max(maxsum , currentval);

        return root.val + Math.max(left , right);

    }



    // ===== MAIN =====
    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left =  new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(12);

        int result = MaxPathsum(root);
        System.out.println(result);

    }
}

