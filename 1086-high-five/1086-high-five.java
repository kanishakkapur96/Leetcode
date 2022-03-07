class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> scoreMap = new TreeMap<>();
        for(int[] score : items){
            int key = score[0];
            int value = score[1];
            if(!scoreMap.containsKey(key)) scoreMap.put(key,new PriorityQueue<>());
            if(scoreMap.get(key).size()<5){
              scoreMap.get(key).offer(value);
            }
            else if(value>scoreMap.get(key).peek()){
                scoreMap.get(key).poll();
                scoreMap.get(key).offer(value);
            }
        }
        int[][] result = new int[scoreMap.keySet().size()][2];
        int counter = 0;
        for(int k: scoreMap.keySet()){
            int sum = 0;
            for(Integer num : scoreMap.get(k)){
                sum += num;
            }
            result[counter][0] = k;
            result[counter][1] = sum/5;
            counter++;
        }
            
        return result;
    }
}