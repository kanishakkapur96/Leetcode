class Solution {
    Map<Integer,Integer> dp =  new HashMap<>(); // memoization
    public int combinationSum4(int[] nums, int target) {
        int result = findCombinations(nums,target);
        return result;
    }
    int findCombinations(int[] nums, int target){
        
        // base cases
        if(target < 0)
            return 0;
        
        if(target == 0){
           return 1;
        }
        
        if(dp.containsKey(target) ){
            return dp.get(target);
        }
        
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
           sum += findCombinations(nums,target-nums[i]);
        }
        
        dp.put(target,sum);
        return sum;
    }
    
    
}