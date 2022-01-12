class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        
        for(int i=0;i<=n;i++){
            // System.out.println(i);
            // System.out.println(binarySearch(nums,i));
            int count =  n - (binarySearch(nums,i));
            if(count == i){
                return count;
            }
        }
        
        return -1;
        
        
    }
    
    // Returns first index of element else -1
    int binarySearch(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(ans == -1) return start;
        return ans;
    }
}