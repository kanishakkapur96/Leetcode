class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[9];
        for(int i=0;i<9;i++){
            nums[i] = i+1;
        }
        generateCombinations(nums,0,n,k,new ArrayList<Integer>(),result);
        return result;
    }
    
    void generateCombinations(int[] nums, int index, int target, int k, List<Integer> ds, List<List<Integer>> result){
        
        // base case
        if(target == 0 && ds.size() == k){
            result.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(nums[i]<=target){
                ds.add(nums[i]);
                generateCombinations(nums,i+1,target-nums[i],k,ds,result);
                ds.remove(ds.size()-1);
            }
        }
    }
}