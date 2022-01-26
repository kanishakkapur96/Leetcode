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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        return checkNode(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    boolean checkNode(TreeNode node, long min, long max){
        if(node.val>min && node.val<max){
            boolean checkLeft = true,checkRight =true;
            if(node.left!=null) checkLeft =  checkNode(node.left,min,node.val);
            if(node.right!=null) checkRight =  checkNode(node.right,node.val,max);
            
            return checkLeft && checkRight;
        }
        
        return false;
    }
}