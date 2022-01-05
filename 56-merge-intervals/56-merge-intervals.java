class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        
        LinkedList<int[]> store = new LinkedList<>();// Holds merged arrays
        for(int i=0;i<n;i++){
           if(store.isEmpty() || store.getLast()[1]<intervals[i][0]){
               store.add(intervals[i]);
           }else{
               store.getLast()[1] = Math.max(store.getLast()[1],intervals[i][1]);
           }
        }
        
       
        return store.toArray(new int[store.size()][]);
    }
}