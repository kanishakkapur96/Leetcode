class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        
        int firstIndex = binarySearch(nums,target,true);
        if(firstIndex != -1){
            int secondIndex = binarySearch(nums,target,false);
            ans[0] = firstIndex;
            ans[1] = secondIndex;
        }
        
        return ans;
        
    }
    
    
     // Simple binary search for first occurence
    public int binarySearch(int[] nums,int target, boolean firstOccurence){
        int n =  nums.length;
        int left = 0;
        int right = n-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                ans = mid;
                if(firstOccurence){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
                 
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return ans;
    }
}