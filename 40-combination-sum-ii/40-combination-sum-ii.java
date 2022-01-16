class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates,0,target,new ArrayList<Integer>(), result);
        return result;
    }
    
    void findCombinations(int[] nums, int index, int target, List<Integer> current, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(current));
        }else{
            for(int i = index;i<nums.length;i++){
                if(i>index && nums[i] == nums[i-1]) continue;
                if(nums[i]>target) break;

                current.add(nums[i]);
                findCombinations(nums,i+1,target-nums[i],current,result);
                current.remove(current.size()-1);
            }
        }
    }
}