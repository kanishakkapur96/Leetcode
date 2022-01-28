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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        
        int leftVal1 = (root1.left !=null) ? root1.left.val : -1;
        int leftVal2 = (root2.left !=null) ? root2.left.val : -1;
        int rightVal1 = (root1.right !=null) ? root1.right.val : -1;
        int rightVal2 = (root2.right!=null)? root2.right.val : -1;
        
        //Flip condition
        if(leftVal1 == leftVal2 && rightVal1 == rightVal2){
            return flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right); 
        }else if(leftVal1 == rightVal2 && rightVal1 == leftVal2){
            return flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left); 
        }
        else{
            return false;
        }
    }
}