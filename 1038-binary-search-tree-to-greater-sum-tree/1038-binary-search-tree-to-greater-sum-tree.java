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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
       // Iterative solution
        
        if(root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(true){
            if(current!=null){
                st.push(current);
                current = current.right;
            }else{
                if(st.isEmpty()){
                    break;
                }
                
                current = st.pop();
                sum += current.val;
                current.val = sum;
                
                current = current.left;
            }
        }
        
        return root;
    }
}