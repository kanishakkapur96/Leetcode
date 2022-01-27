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
    public TreeNode bstFromPreorder(int[] preorder) {
      return createBst(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    
    TreeNode createBst(int[] preOrder, int upper, int[] index){
      if(index[0] == preOrder.length || preOrder[index[0]]>upper) return null;
      TreeNode root = new TreeNode(preOrder[index[0]++]);
      root.left = createBst(preOrder,root.val,index);
      root.right = createBst(preOrder,upper, index);
        
      return root;
    }
    
    
}