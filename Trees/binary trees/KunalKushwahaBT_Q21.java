// given a tree and array with path check if the path exists in Tree or not 
 public class KunalKushwahaBT_Q21{

     static class TreeNode{
        int val;
        TreeNode left , right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static boolean hasPath(TreeNode root , int[] arr){
        if (root == null) return arr.length == 0;
        return helper(root, arr ,0);

            

        }
    static boolean helper(TreeNode root , int[] arr , int index){
        if(root ==  null || index >= arr.length) return false;

        // check for value mismatch
        if(root.val != arr[index]) return false;

        // check for last leaf 
        if(root.left == null && root.right == null && index ==  arr.length -1) {
            return true;
        }

        return helper(root.left ,arr,index + 1) || helper(root.right,arr,index + 1);


    }

    public static void main(String[]  args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(12);
        root.right.left.left = new TreeNode(16);
        root.right.right.right = new TreeNode(8);
        int[] arr1 = {3,9,12,8};
        int[] arr2 ={9,12,8};
        boolean result1 =  hasPath(root , arr1);
        boolean result2 = hasPath(root , arr2);
        System.out.println(result1);
        System.out.println(result2);
    }

}

    


