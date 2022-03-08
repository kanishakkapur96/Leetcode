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
    public TreeNode bstToGst(TreeNode root) {
       
        convertTree(root,new int[]{0});
        return root;
    }
    
    public void convertTree(TreeNode root, int[] sum){
        
        if(root == null) return ;
        if(root.left == null && root.right == null) {
            root.val = sum[0] + root.val;
            sum[0] = root.val;
            return;
        }

        if(root.right!=null) convertTree(root.right, sum);
        
        
        root.val = root.val + sum[0];
        sum[0] = root.val;
        
        if(root.left!=null) convertTree(root.left, sum);
    }
}