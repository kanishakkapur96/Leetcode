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
    public int deepestLeavesSum(TreeNode root) {
        // Find the deepest level
        int h = height(root);
        int[] ans = new int[]{0};
        leafSum(root,1,h, ans);
        return ans[0];
    }
    
    int height(TreeNode root){
        if(root == null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
    
    void leafSum(TreeNode root, int currDepth, int reqDepth, int[] sum){
        if(currDepth == reqDepth) {
            sum[0]+=root.val;
            return;
        }
        
        if(root.left!=null) leafSum(root.left,currDepth+1,reqDepth,sum);
        if(root.right!=null) leafSum(root.right,currDepth+1,reqDepth,sum);
    }
}