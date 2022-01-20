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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int h = findDiameter(root);
        return diameter;
    }
    
    int findDiameter(TreeNode root){
        if(root == null) return 0;
        int left = findDiameter(root.left);
        int right= findDiameter(root.right);
        diameter = Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
    
    
}