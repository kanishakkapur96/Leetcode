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
    /* Using level order traversal*/
    public int maxDepth(TreeNode root) {
       if(root == null) return 0;
        
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       int counter = 0;
       while(!q.isEmpty()){
           int len = q.size();
           counter++;
           for(int i =0;i<len;i++){
               TreeNode curr = q.poll();
               if(curr.left!=null) q.offer(curr.left);
               if(curr.right!=null) q.offer(curr.right);
           }
       }
        
       return counter;
    }
}