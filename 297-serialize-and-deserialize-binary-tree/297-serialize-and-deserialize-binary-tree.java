/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder("");
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("# ");
            }else{
                sb.append(curr.val+" ");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] dataArr = data.split(" ");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        q.offer(root);
        
        for(int i=1;i<dataArr.length;i++){
            TreeNode current = q.poll();
            if(!dataArr[i].equals("#")){
                 TreeNode leftNode = new TreeNode(Integer.parseInt(dataArr[i]));
                 current.left = leftNode;
                 q.offer(leftNode);
            }else{
                current.left = null;
            }
            
            if(!dataArr[++i].equals("#")){
                 TreeNode rightNode = new TreeNode(Integer.parseInt(dataArr[i]));
                 current.right = rightNode;
                 q.offer(rightNode);
            }else{
                current.right =null;
            }
                
        }
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));