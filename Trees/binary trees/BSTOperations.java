public class BSTOperations {
    static class TreeNode{
        int val;
        TreeNode left,right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static  boolean search(TreeNode root , int target){
        if(root == null) return false;
        if(root.val == target) return true;

        if(root.val  < target) {
            return search(root.left , target);
        }
        else { 
            return search(root.right , target);

        }

    }
        // Insert

    static TreeNode insert(TreeNode root , int target){
        if(root == null) return new TreeNode(target);
        if(target <  root.val) {
            root.left = insert(root.left, target);
                }        else{
                    root.right = insert(root.right, target);
        }
        return root;
    }

    static TreeNode delete(TreeNode root , int target){
        if(root == null)  return null;
        if(target < root.val){
            root.left = delete(root.left , target);
        }
         else if(target > root.val){
            root.right = delete(root.right , target);
        }

        else{
            // no left child
            if(root.left ==  null) return root.right;

            // no right child
             if(root.right ==  null) return root.left;

             // two child
             TreeNode successor =  findMin(root.right);
             root.val = successor.val;
             root.right = delete(root.right , successor.val);




        }
        return root;
    }
        static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 🖨️ Inorder (to check sorted)
    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = null;

        // Build BST
        int[] values = {10, 5, 20, 3, 7, 25};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder (sorted): ");
        inorder(root);

        // Search
        System.out.println("\nSearch 7: " + search(root, 7));

        // Insert
        root = insert(root, 6);
        System.out.print("After inserting 6: ");
        inorder(root);

        // Delete
        root = delete(root, 10);
        System.out.print("\nAfter deleting 10: ");
        inorder(root);
    }


    
    
}
