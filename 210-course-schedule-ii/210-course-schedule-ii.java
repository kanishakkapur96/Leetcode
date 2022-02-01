class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Create Hashmap
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites){
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        
        // Create Indegree array
        int[] topo = new int[numCourses];
        int[] inDeg = new int[numCourses];
        for(int i=0;i<numCourses;i++){
          if(map.containsKey(i)){
            for(Integer point : map.get(i)){
                inDeg[point]++;
            }
          }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDeg[i] == 0){
                q.offer(i);
            }
        }
        
        int index = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[index++] = node;
            if(map.containsKey(node)){
             for(Integer it : map.get(node)){
                inDeg[it] --;
                if(inDeg[it] == 0){
                    q.offer(it);
                }
             }
            }
            
        }
        
        if(index != numCourses) return new int[0];
        
        return topo;
        
    }
}