/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node,new HashMap<Node,Node>());
    }
    
    Node dfs(Node root, Map<Node,Node> oldToNew){
        if(!oldToNew.containsKey(root)){
            Node copy = new Node(root.val);
            oldToNew.put(root,copy);
            
            for(Node neigh : root.neighbors){
                copy.neighbors.add(dfs(neigh,oldToNew));
            }
            
            return copy;
            
        }else{
            return oldToNew.get(root);
        }
    }
}