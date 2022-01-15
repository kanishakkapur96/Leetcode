class Solution {
    int total ;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        
        return generateExpression(nums,0,0,target,memo);
    }
    
    int generateExpression(int[] nums,int sum, int i, int target,int[][] memo){
        // base case
        if(i == nums.length && sum == target){
            return 1;
        } else if(i == nums.length && sum != target){
            return 0;
        } else {
            if (memo[i][sum + total] != Integer.MIN_VALUE) {
                return memo[i][sum + total];
            }
            
             // choices
            int add = generateExpression(nums, sum+nums[i], i+1,target,memo);
            int subtract = generateExpression(nums,sum - nums[i], i+1, target,memo);
            memo[i][sum + total] = add + subtract;
            return memo[i][sum + total];
        }
       
    }
    
    
}