class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean ans = hasCycle(numCourses,prerequisites);
        return !ans;
    }
    
    // Detect cycle in directed graph using dfs
    
    boolean hasCycle(int num, int[][] pre){
        int[] visited = new int[num];
        int[] dfsVisited = new int[num];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : pre){
            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
        }
        
        for(int i=0;i<num;i++){
            if(visited[i] == 0){
                if(checkCycle(i,map,visited,dfsVisited)) return true;
            }
        }
        
        return false;
    }
    
    boolean checkCycle(int node, Map<Integer,List<Integer>> pre, int[] visited, int[] dfsVisited){
        visited[node] = 1;
        dfsVisited[node] = 1;
        if(pre.containsKey(node)){
            for(int i: pre.get(node)){
                if(visited[i] == 0){
                    if(checkCycle(i,pre,visited,dfsVisited)) return true;
                }else if(dfsVisited[i] == 1){
                    return true;
                }
            }
        }
        
        dfsVisited[node] = 0;
        return false;
    }
}