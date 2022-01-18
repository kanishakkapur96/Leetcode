class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(Integer n: nums){
            sum += n;
        }
        
        if(sum % k != 0){
            return false;
        }
        int target = sum/k;
        boolean[] visited = new boolean[nums.length];
        return checkPartitions(nums,0,target,visited,0,k);
        
        
    }
    
    boolean checkPartitions(int[] nums, int index,int target, boolean[] visited, int subsetSum, int k){
        if(k == 0)
            return true;
        
        // Check for other buckets
        if(subsetSum == target){
            return checkPartitions(nums,0,target,visited,0,k-1);
        }
        
        for(int i=index;i<nums.length;i++){
            if(visited[i] == true || subsetSum + nums[i]>target) continue;
            
            // Pick the element
            visited[i] = true;
            if(checkPartitions(nums,i+1,target,visited,subsetSum+nums[i],k)) return true;
            visited[i] = false;
        }
        
        return false;
        
    }
}