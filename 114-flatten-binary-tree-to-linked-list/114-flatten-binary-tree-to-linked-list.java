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
    public void flatten(TreeNode root) {
        createLinkedList(root);
    }
    
    TreeNode createLinkedList(TreeNode node){
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        
        TreeNode left = createLinkedList(node.left);
        TreeNode right = createLinkedList(node.right);
        
        
        if(left!=null){
             node.right = left;
             node.left = null;
        }
           
        
        if(left == null){
            node.right = right;
        }
        // Traverse uptil right most element of left
        if(left!=null && right!=null){
            TreeNode current = node.right;
            while(current.right!=null)
                current = current.right;

            current.right = right;
        }
       
        return node;
        
    }
}