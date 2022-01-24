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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
        
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,index);
    }
    
    TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer,Integer> index){
        if(preStart>preEnd || inStart>inEnd) return null;
        
        TreeNode root = new TreeNode(preOrder[preStart]);
        int rootPos = index.get(preOrder[preStart]);
        int leftNum = rootPos - inStart;
            
        root.left = buildTree(preOrder,preStart+1,preStart+leftNum,inOrder,inStart,rootPos-1,index);
        root.right = buildTree(preOrder,preStart+leftNum+1,preEnd,inOrder,rootPos+1,inEnd,index);
        
        return root;
    }
}