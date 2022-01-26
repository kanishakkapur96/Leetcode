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
    public int kthSmallest(TreeNode root, int k) {
        return inorderTraversal(root,k);
    }
    public int inorderTraversal(TreeNode root, int k) {
       
        if(root == null) return -1;
        int count = 0;
        TreeNode current = root;
        
        while(current!=null){
            
            if(current.left == null){
                count++;
                if(count == k)
                    return current.val;
                current = current.right;
            }else{
                
                // Go to right most of left tree
                TreeNode prev = current.left;
                while(prev.right!=null && prev.right!=current){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                }else if(prev.right== current){
                    prev.right = null;
                    count++;
                    if(count == k)
                        return current.val;
                    
                    current = current.right;
                }
                
            }
            
        }
        
        return -1;
    }
}