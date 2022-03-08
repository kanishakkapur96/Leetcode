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
    // Level order traversal
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int count = 0;
            int sum = 0;
            while(count<size){
                
                TreeNode current = q.poll();
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
                sum+=current.val;
                count++;
            }
            
            if(q.isEmpty()){
                ans = sum;
            }
        }
        
        return ans;
    }
}