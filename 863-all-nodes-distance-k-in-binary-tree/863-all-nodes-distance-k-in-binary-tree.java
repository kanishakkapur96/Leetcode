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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        makeParents(root,parent);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int curr_level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                
                if(curr.left!=null && visited.get(curr.left) == null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                 if(curr.right!=null && visited.get(curr.right) == null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                 if(parent.get(curr)!=null && visited.get(parent.get(curr)) == null){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }
    void makeParents(TreeNode root, Map<TreeNode,TreeNode> map){
        if(root == null)
            return;
        
        if(root.left!=null){
            map.put(root.left,root);
            makeParents(root.left,map);
        }
        if(root.right!=null){
            map.put(root.right,root);
            makeParents(root.right,map);
        }
    }
}