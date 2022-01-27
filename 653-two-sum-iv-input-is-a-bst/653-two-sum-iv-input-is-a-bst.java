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
    class BstIterator{
        Stack<TreeNode> stack = new Stack<>();
        Boolean reverse =  false;
        
        BstIterator(TreeNode root, boolean isReverse){
           reverse = isReverse;
           pushAll(root,isReverse);
        }
        
        int next(){
            TreeNode root = stack.pop();
            if(reverse)
                pushAll(root.left,reverse);
            else
                pushAll(root.right,reverse);
            
            return root.val;
        }
        
        void pushAll(TreeNode root, boolean isReverse){
            
            while(root!=null){
                stack.push(root);
                if(isReverse)
                    root = root.right;
                else
                    root = root.left;
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BstIterator l = new BstIterator(root,false);
        BstIterator r = new BstIterator(root, true);
        
        int i = l.next();
        int j = r.next();
        
        while(i<j){
            if(i+j == k) return true;
            else if(i+j<k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}