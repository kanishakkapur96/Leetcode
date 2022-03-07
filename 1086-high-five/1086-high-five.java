class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> scoreMap = new HashMap<>();
        for(int[] score : items){
            if(!scoreMap.containsKey(score[0])) scoreMap.put(score[0],new PriorityQueue<>(Collections.reverseOrder()));
            
            scoreMap.get(score[0]).offer(score[1]);
        }
        int[][] result = new int[scoreMap.keySet().size()][2];
        int counter = 0;
        for(int k: scoreMap.keySet()){
            int sum = 0;
            for(int i=0;i<5;i++){
                sum += scoreMap.get(k).poll();
            }
            result[counter][0] = k;
            result[counter][1] = sum/5;
            counter++;
        }
        
        Arrays.sort(result,(a,b)-> {
            if(a[0]<b[0]) return -1;
            if(a[0]==b[0]) return 0;
            return 1;
        });
            
        return result;
    }
}