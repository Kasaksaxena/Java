public class DFSorders {

   static class TreeNode{
        int val ;
        TreeNode left , right ;

        TreeNode(int val ){
            this.val = val;
            left = right = null ;
        }
    }

    static void Preorder(TreeNode root){
        if (root  == null) return;

        System.out.print( root.val + " ");
        Preorder(root.left);
        Preorder(root.right);

    }

    static void Inorder(TreeNode root){
        if (root  == null) return;

        Inorder(root.left);
        System.out.print( root.val + " ");
        Inorder(root.right);

    }

    static void Postorder(TreeNode root){
        if (root  == null) return;

       
        Preorder(root.left);
        Preorder(root.right);
        System.out.print( root.val + " ");

    }
     public static void main(String[] args) {

        // Build tree manually
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Preorder: ");
        Preorder(root);

        System.out.print("\nInorder: ");
        Inorder(root);

        System.out.print("\nPostorder: ");
        Postorder(root);
    }
    
}
