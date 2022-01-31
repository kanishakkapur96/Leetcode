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
    public List<String> binaryTreePaths(TreeNode root) {
        String sb = "";
        List<String> result = new ArrayList<>();
        generateStrings(root,sb,result);
        return result;
    }
    
    void generateStrings(TreeNode root, String sb, List<String> result){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sb = sb + root.val;
            result.add(sb);
        }else{
            String l = sb + root.val+"->";
            generateStrings(root.left,l,result);
            generateStrings(root.right,l,result);
        }
        
        
    }
}