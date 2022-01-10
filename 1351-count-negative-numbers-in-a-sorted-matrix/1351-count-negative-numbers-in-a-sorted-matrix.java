class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        
        for(int i=0;i<grid.length;i++){
            int index = floor(grid[i],0);
            int n = grid[i].length;
            if(index!=-1)
                count = count + (n - index);
        }
        
        return count;
    }
    int floor(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=target){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}