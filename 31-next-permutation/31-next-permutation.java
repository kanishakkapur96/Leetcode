class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int i = nums.length-2;
        int n = nums.length;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        // Found the peak
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
                        
            // swap index 1 and index 2
            swap(nums,i, j);
            
            // reverse remaining array
            reverse(nums,i+1, nums.length-1);
            
        }else{
            reverse(nums,0,nums.length-1);
        }
        
    }
    void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    void reverse(int[] nums, int start, int end){
        int left = start;
        int right = end;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}