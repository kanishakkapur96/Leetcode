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
    // Morris traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode current = root;
        while(current!=null){
            
            if(current.left == null){
                result.add(current.val);
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
                    result.add(current.val);
                    current = current.right;
                }
                
            }
            
        }
        
        return result;
    }
}