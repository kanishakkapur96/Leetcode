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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int lh = findHeight(root.left,true);
        int rh = findHeight(root.right,false);
        
        if(lh == rh)
            return (2<<lh)-1;
        
        return 1 + countNodes(root.left)+countNodes(root.right);
    }
    
    int findHeight(TreeNode node, boolean isLeft){
        if(node == null) return 0;
        int height = 0;
        TreeNode current = node;
        while(current!=null){
            height++;
            if(isLeft)
                current = current.left;
            else
                current = current.right;
        }
        return height;
    }
    
     
}