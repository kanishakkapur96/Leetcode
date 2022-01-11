class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeroCount = 0;
        int n = nums.length, maxLen = Integer.MIN_VALUE;
        while(end<n){
            if(nums[end] == 1){
                maxLen = Math.max(maxLen,end-start+1);
                end++;
            }
            else if(nums[end] == 0){
                // check if zeroCount is less than k
                if(zeroCount<k){
                    maxLen = Math.max(maxLen,end-start+1);
                    end++;
                    zeroCount++;
                }else if(zeroCount>=k){
                    // move start pointer to position where zeroCount is reduced
                    while(zeroCount>=k){
                        if(nums[start] == 0){
                            zeroCount --;
                        }
                        start++;
                    }
                }
            }
        }
        
        return maxLen;
    }
}