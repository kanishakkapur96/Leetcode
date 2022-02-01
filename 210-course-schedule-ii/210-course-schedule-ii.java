class Solution {
    boolean containsCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topologicalOrder(numCourses,prerequisites);
    }
    
     int[] topologicalOrder(int num, int[][] pre){
        int[] visited = new int[num];
        int[] dfsVisited = new int[num];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : pre){
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<Integer>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num;i++){
            if(containsCycle){
                return new int[0];
            }
               
            if(visited[i] == 0){
                topologicalSort(i,map,visited,dfsVisited,stack);
            }
        }
         
        
        int[] res = new int[stack.size()];
        int len = stack.size();
        for(int i=0;i<len;i++){
            int r = stack.pop();
            res[i] = r;
        }
        
        
        return res;
    }
    
    void topologicalSort(int node, Map<Integer,List<Integer>> pre, int[] visited, int[] dfsVisited, Stack<Integer> stack){
        visited[node] = 1;
        dfsVisited[node] = 1;
        if(pre.containsKey(node)){
            for(int i: pre.get(node)){
                if(visited[i] == 0){
                    topologicalSort(i,pre,visited,dfsVisited,stack);
                }else if(dfsVisited[i] == 1){
                    containsCycle = true;
                    return;
                }
            }
        }
        
        dfsVisited[node] = 0;
        stack.push(node);
    }
}