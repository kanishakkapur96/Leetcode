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
    class Tuple{
        int row;
        int col;
        TreeNode node;
        
        Tuple(TreeNode n , int row, int col){
            this.col = col;
            this.row = row;
            this.node = n;
        }
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        Tuple r =  new Tuple(root,0,0);
        q.offer(r);
        TreeMap<Integer,PriorityQueue<Integer>> colMap = new TreeMap<>();
        colMap.put(0,new PriorityQueue<Integer>());
        
        map.put(0,colMap);
        
        // Level order traversal
        while(!q.isEmpty()){
            
            Tuple curr = q.poll();
            TreeNode currNode = curr.node;
            int row = curr.row;
            int col = curr.col;
            
            // Insert polled tuple into datastructure
            if(!map.containsKey(row)){
                TreeMap<Integer,PriorityQueue<Integer>> subMap = new TreeMap<>();
                map.put(row,subMap);
            }
            
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col,new PriorityQueue<Integer>());
            }
            
            map.get(row).get(col).add(currNode.val);
            
            // Create tuples for left and right
            if(currNode.left!=null) q.offer(new Tuple(currNode.left,row-1,col+1));
            if(currNode.right!=null) q.offer(new Tuple(currNode.right,row+1,col+1));
            
        }
        
        
        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> m : map.values()){
            ArrayList<Integer> subList = new ArrayList<>();
            for(PriorityQueue<Integer> pq : m.values()){
                while(!pq.isEmpty()){
                   subList.add(pq.poll());
                }
            }
            result.add(subList);
        }
        
        return result;
        
        
    }
}