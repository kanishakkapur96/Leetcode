class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int start = floor(nums,target);
        int end = ceil(nums,target);
        List<Integer> result = new ArrayList<Integer>();
        if(start == -1 || end == -1){
            return result;
        }
        
        for(int i = start;i<=end;i++){
            result.add(i);
        }
        return result;
    }
    
    int ceil(int[] nums, int target){
        int start = 0;
        int end =  nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = end+(start-end)/2;
            if(nums[mid]<=target){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    
    int floor(int[] nums, int target){
        int start = 0;
        int end =  nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = end+(start-end)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}