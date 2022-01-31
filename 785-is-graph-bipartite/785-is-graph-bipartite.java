class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0;i<n;i++){
            color[i] = -1;
        }
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!checkBipartite(i,graph,color)) return false;
            }
        }
        return true;
    }
    
    public boolean checkBipartite(int index, int[][] graph, int[] color){
        
        if(color[index] == -1) color[index] = 1;
        for(int i: graph[index]){
            if(color[i] == -1){
                color[i] = 1 - color[index];
                if(!checkBipartite(i,graph,color)) return false;
            }else{
                if(color[i] == color[index]){
                    return false;
                }
            }
        }
        return true;

    }
}