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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
        
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,index);
    }
     TreeNode buildTree(int[] postOrder, int posStart, int posEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer,Integer> index){
        if(posStart>posEnd || inStart>inEnd) return null;
        
        TreeNode root = new TreeNode(postOrder[posEnd]);
        int rootPos = index.get(postOrder[posEnd]);
        int leftNum = rootPos - inStart;
            
        root.left = buildTree(postOrder,posStart,posStart+leftNum-1,inOrder,inStart,rootPos-1,index);
        root.right = buildTree(postOrder,posStart+leftNum,posEnd-1,inOrder,rootPos+1,inEnd,index);
        
        return root;
    }
}