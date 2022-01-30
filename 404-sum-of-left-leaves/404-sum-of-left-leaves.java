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
    public int sumOfLeftLeaves(TreeNode root) {
       int[] sum = new int[]{0};
       sumLeft(root,sum);
       return sum[0];
    }
    
    void sumLeft(TreeNode root, int[] sum){
        if(root == null || (root.left == null && root.right== null)) return;
        if(root.left!=null){
            TreeNode l = root.left;
            if(l.left ==null && l.right ==null){
                sum[0] += l.val;
            }else{
                sumLeft(l,sum);
            }
        }
        
        sumLeft(root.right,sum);
    }
}