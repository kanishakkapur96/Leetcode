class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] exFirst = new int[nums.length-1];
        int[] exLast = new int[nums.length-1];
        int index1 = 0,index2 = 0;
        for(int i=0;i<nums.length;i++){
            if(i!=0) {
                exFirst[index1] = nums[i];
                index1++;
            }
            if(i!=nums.length-1) {
                exLast[index2] = nums[i];
                index2++;
            }
        }
        
        return Math.max(maxMoney(exFirst),maxMoney(exLast));
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