import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {
    
    // Method 1: Recursive (DFS)
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    // Method 2: Iterative (BFS using a Queue)
    // Sometimes interviewers ask for this to avoid stack overflow on deep trees
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;
            
            // Add children in mirror order: 
            // (Left-Left with Right-Right) and (Left-Right with Right-Left)
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        // Creating a symmetric tree:
        //      1
        //    /   \
        //   2     2
        //  / \   / \
        // 3   4 4   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree solution = new SymmetricTree();
        System.out.println("Is tree symmetric? " + solution.isSymmetric(root));
    }
}