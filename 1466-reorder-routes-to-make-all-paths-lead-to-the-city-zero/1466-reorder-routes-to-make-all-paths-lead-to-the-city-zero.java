class Solution {
    
    class Pair{
        int a;
        int b;
        Pair(int p,int q){
            a=p;
            b=q;
        }
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair)o;
                return p.a == a && p.b == b;
            }
            return false;
        }
        public int hashCode() {
            return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
        }
    }

    public int minReorder(int n, int[][] connections) {
        
        // Keep track of neighbors
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        HashSet<Pair> edgeList = new HashSet<>();
        //int[][] edgeMatrix = new int[n][n];
        for(int[] edge: connections){
            if(!neighbor.containsKey(edge[0])){
                neighbor.put(edge[0],new ArrayList<Integer>());
            }
            if(!neighbor.containsKey(edge[1])){
                neighbor.put(edge[1],new ArrayList<Integer>());
            }
            
            neighbor.get(edge[0]).add(edge[1]);
            neighbor.get(edge[1]).add(edge[0]);
            //edgeMatrix[edge[0]][edge[1]] = 1;
            edgeList.add(new Pair(edge[0],edge[1]));
        }
        
        int[] count = new int[]{0};
        HashSet<Integer> visited = new HashSet<>();
        dfs(0,neighbor,edgeList,count,visited);
        
        
        return count[0];
        
    }
    
    void dfs(int node,Map<Integer, List<Integer>> neighbor, HashSet<Pair> edgeList, int[] count,HashSet<Integer> visited ){
        
        visited.add(node);
        //Check all neighbors
        for(int neigh : neighbor.get(node)){
            if(visited.contains(neigh)) continue;
            if(!edgeList.contains(new Pair(neigh,node))){
                count[0]+=1;
            }
            dfs(neigh,neighbor,edgeList,count,visited);
        }
    }
}