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
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        color[index] = 1;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(int i: graph[node]){
                if(color[i] == -1){
                    q.offer(i);
                    color[i] = 1 - color[node];
                }else{
                    if(color[i] == color[node]){
                        return false;
                    }
                }
            }
        }
        
        return true;

    }
}