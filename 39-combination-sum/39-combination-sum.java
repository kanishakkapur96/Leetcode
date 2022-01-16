class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
    
    void generateCombinations(int[] nums, int index,int target, List<Integer> current, List<List<Integer>> result){
        // base cases
        if(target == 0){
                result.add(new ArrayList<Integer>(current));
        }else{
            for(int i = index;i<nums.length;i++){
               if(nums[i]<=target){
                    current.add(nums[i]);
                    generateCombinations(nums,i,target-nums[i],current,result);
                    current.remove(current.size()-1);
               }
            }
        }
    }
}