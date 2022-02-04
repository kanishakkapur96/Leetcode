class Solution {
    
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1;i<=n;i++){
            rank[i] = 1;
            parent[i] = i;
        }
        
        int[] count = new int[]{n};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    union(rank,parent,i+1,j+1,count);
                    isConnected[j][i] = 0;
                }
            }
        }
        
        return count[0];
    }
    
    int find(int node, int[] parent){
        int p = parent[node];
        while(p!=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        
        return p;
    }
    
    void union(int[] rank,int[] parent, int node1,int node2, int[] count){
        int p1 = find(node1,parent);
        int p2 = find(node2,parent);
        
        if(p1 == p2){
            return;
        }
        
        count[0]--;
        if(rank[p1]>rank[p2]){
            rank[p1]+=rank[p2];
            parent[p2] = p1;
        }
        else {
            rank[p2]+=rank[p1];
            parent[p1] = p2;
        }
    }
}