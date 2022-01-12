class Solution {
     public int searchIndex(int[] nums, int target) {
        int pivot = findPivot(nums);
        int n = nums.length;
        if(pivot == -1){
            return binarySearch(nums,0,n-1,target);
        }
        
        if(target == nums[pivot]){
            return pivot;
        }
        
        if(target>=nums[0]){
            return binarySearch(nums,0,pivot-1,target);
        }
        
        return binarySearch(nums,pivot+1,nums.length-1,target);
    }
    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid < end && nums[mid]>nums[mid+1]){
                return mid;
            }else if(mid > start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            
            // If start, mid and end are equal
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                
                // check if start and end are pivots
                if(start+1<nums.length && nums[start]>nums[start+1]){
                    return start;
                }
                start++;
                if(end>0 && nums[end]<nums[end-1]){
                    return end-1;
                }
                end --;
                
            }
            // left side is sorted
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[end]<nums[mid])){
                start= mid+1;
            }
            else{
                end = mid-1;
            }
            
            // else if(nums[start] >= nums[mid]){
            //    end = mid-1;
            // }else if(nums[start] < nums[mid]){
            //     start = mid+1;
            // }
        }
        
        return -1;
    }
    
   
     public int binarySearch(int[] nums, int start, int end, int target) {
       
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<target){
                start = mid+1;
            }else {
                end = mid-1;
            }
            
        }
        
        return -1;
    }
    public boolean search(int[] nums, int target) {
        int ans = searchIndex(nums,target);
        if(ans == -1)
            return false;
        return true;
    }
}