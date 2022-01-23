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
    
    class Pair{
        TreeNode node;
        int index;
        
        Pair(TreeNode n, int i){
            node = n;
            index = i;
        }
    }
    
    
    public int widthOfBinaryTree(TreeNode root) {
        int ans = levelOrder(root);
        return ans;
    }
    
    int levelOrder(TreeNode root){
        int maxWidth = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,1));
        
        while(!q.isEmpty()){
            int len = q.size();
            int first = -1, last = -1;
            for(int i=0;i<len;i++){
                Pair current = q.poll();
                TreeNode currNode = current.node;
                int currIndex = current.index;
                if(i == 0){
                    first = currIndex;
                }
                
                if( i == len -1)
                    last = currIndex;
                
                if(currNode.left!=null){
                    q.offer(new Pair(currNode.left, 2*(currIndex-first)+1));
                }
                
                if(currNode.right!= null){
                    q.offer(new Pair(currNode.right,2*(currIndex-first)+2));
                }
            }
            
            maxWidth = Math.max(maxWidth,last-first+1);
            
        }
        
        return maxWidth;
    }
}