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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = generateMaxTree(0,nums.length-1,nums);
        return root;
    }
    
    public TreeNode generateMaxTree(int start, int end, int[] nums){
        if(start>end) return null;
        
        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for(int i = start; i<=end; i++){
            if( nums[i] > maxVal ) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        
        TreeNode root =  new TreeNode(maxVal);
        root.left = generateMaxTree(start,maxIndex-1,nums);
        root.right = generateMaxTree(maxIndex+1,end,nums);
        
        return root;
        
    }
}