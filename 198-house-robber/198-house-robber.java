class Solution {
    public int rob(int[] nums) {
        
        return maxMoney(nums);
    }
    
    int maxMoney(int[] nums){
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        
        int prev = Math.max(nums[0],nums[1]) , prev_prev = nums[0];
        int maxVal = -1;
        for(int i=2;i<nums.length;i++){
            maxVal = Math.max(prev, nums[i]+prev_prev);
            prev_prev = prev;
            prev = maxVal;
        }
        
        return maxVal;
    }
}