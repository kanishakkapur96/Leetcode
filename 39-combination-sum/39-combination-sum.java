class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(candidates,target,0,result,new ArrayList<>());
        return result;
    }
    
    void generateCombinations(int[] nums,int target, int i, List<List<Integer>> result, List<Integer> current){
        // base cases
        if(target == 0 && current.size()>0){
            result.add(new ArrayList<Integer>(current));
        }else{
            
            if(i == nums.length){
                if(target == 0){
                    result.add(new ArrayList<Integer>(current));
                }
            }else{
                // pick the element
                if(nums[i]<=target){
                    current.add(nums[i]);
                    generateCombinations(nums,target-nums[i],i,result,current);
                    current.remove(current.size()-1);
                }

                // Donot pick the element
                generateCombinations(nums,target,i+1,result,current);
            }
        }
    }
}