class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph =  new HashMap<>();
        
        
        for(int[] edge : times){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0],new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1,info2) -> info1[0]-info2[0]);
        heap.offer(new int[]{0,k});
        HashSet<Integer> visited = new HashSet<>();
        int maxLen = 0;
        while(!heap.isEmpty()){
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if(visited.contains(node)) continue;
            maxLen = Math.max(maxLen,d);
            
            visited.add(node);
            if(graph.containsKey(node)){
                for(int[] edge : graph.get(node)){
                    int nei = edge[0], d2 = edge[1];
                    if(!visited.contains(nei)){
                        heap.offer(new int[]{d+d2,nei});
                    }
                }
            }
        }
        
        if(visited.size()!=n) return -1;
        return maxLen;
        
        
        
    }
}