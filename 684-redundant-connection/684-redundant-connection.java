class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        // Initialise
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int[] edge: edges){
            if(!union(rank,parent,edge[0],edge[1])){
                return edge;
            }
        }
        
        return new int[0];
        
    }
    
    int find(int[] parent, int node){
        int p = parent[node];
        while(p!=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    boolean union(int[] rank, int[] parent, int node1, int node2){
        int p1 = find(parent,node1);
        int p2 = find(parent,node2);
        
        if(p1 == p2){
            return false;
        }
        
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
            rank[p1]+=rank[p2];
        }else{
            parent[p1] = p2;
            rank[p2]+=rank[p1];
        }
        
        return true;
    }
}