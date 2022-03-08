/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        String actions = search(original, target, "");
        if(actions == null) return null;
        TreeNode current = cloned;
        for(int i=0;i<actions.length();i++){
            if(actions.charAt(i) == 'L') current = current.left;
            if(actions.charAt(i) == 'R') current = current.right;
        }
        
        return current;
    }
    
    String search(TreeNode root, TreeNode target, String s){
        if(root == target) return s;
        if(root.left!=null){
            String seq = search(root.left,target,s+"L");
            if(seq!=null) return seq;
        }
        if(root.right!=null){
           String seq = search(root.right,target,s+"R");
           if(seq!=null) return seq;
        }
        
        return null;
    }
}