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
    public int sumEvenGrandparent(TreeNode root) {
        int[] ans = new int[1];
        findSum(root,ans);
        return ans[0];
    }
    
    public void findSum(TreeNode root, int[] sum){
        if(root!=null){
            // Find grand children
            if(root.val%2 == 0){
                if(root.left!=null){
                    TreeNode leftChild = root.left;
                    if(leftChild.left!=null) sum[0] = sum[0] + leftChild.left.val;
                    if(leftChild.right!=null) sum[0] = sum[0] + leftChild.right.val;
                }
                
                if(root.right!=null){
                    TreeNode rightChild = root.right;
                    if(rightChild.left!=null) sum[0] = sum[0] + rightChild.left.val;
                    if(rightChild.right!=null) sum[0] = sum[0] + rightChild.right.val;
                }
            }
            
            findSum(root.left,sum);
            findSum(root.right,sum);
        }
    }
}