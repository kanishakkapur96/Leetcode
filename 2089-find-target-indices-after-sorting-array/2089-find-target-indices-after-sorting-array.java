class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int belowTarget = 0, equalTarget = 0;
        for(Integer i : nums){
            if(i<target){
                belowTarget++;
            }else if(i == target){
                equalTarget ++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<equalTarget;i++){
            result.add(belowTarget++);
        }
        
        return result;
    }
}