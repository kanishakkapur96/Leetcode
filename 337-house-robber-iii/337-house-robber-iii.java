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
    
    public int rob(TreeNode root)
    {
        int[] res = findMaxSubset(root);
        return Math.max(res[0],res[1]);
    }
    
    int[] findMaxSubset(TreeNode root){
        if(root == null) return new int[]{0,0};
        
        int[] l = findMaxSubset(root.left);
        int[] r = findMaxSubset(root.right);
        
        int[] res = new int[2];
        res[0] = Math.max(l[0],l[1])+Math.max(r[0],r[1]);
        res[1] = root.val + l[0] + r[0];
        return res;
    }
}