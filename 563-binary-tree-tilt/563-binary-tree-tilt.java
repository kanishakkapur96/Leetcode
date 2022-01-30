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
    public int findTilt(TreeNode root) {
        int[] ans = new int[]{0};
        calculateTilt(root,ans);
        return ans[0];
    }
    
    int calculateTilt(TreeNode root, int[] sum){
        if(root == null) return 0;
        int left =  calculateTilt(root.left,sum);
        int right = calculateTilt(root.right,sum);
        
        int tilt = Math.abs(left-right);
        sum[0]+=tilt;
        
        return root.val+left+right;
    }
}