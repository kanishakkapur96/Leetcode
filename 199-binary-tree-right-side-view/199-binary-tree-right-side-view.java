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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        generateRightView(root,0,result);
        return result;
    }
    
    void generateRightView(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return;
        }
        
        if(level == result.size())
            result.add(root.val);
        
        if(root.right!=null) generateRightView(root.right,level+1,result);
        if(root.left!=null) generateRightView(root.left,level+1,result);
    }
}