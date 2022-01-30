/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Reverse in order traversal
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[]{0};
        generateBst(root,sum);
        return root;
    }
    
    public void generateBst(TreeNode root, int[] sum){
        if(root == null) return;
        generateBst(root.right,sum);
        root.val = root.val + sum[0];
        sum[0] = root.val;
        
        generateBst(root.left, sum);
        
    }
}