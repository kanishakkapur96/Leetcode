class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] included = new boolean[21]; // if size is not known, we can use hashmap
        generatePerms(nums,included,new ArrayList<Integer>(),result);
        return result;
    }
    
    void generatePerms(int[] nums, boolean[] included, List<Integer> ds, List<List<Integer>> result){
        // base case
        if(ds.size() == nums.length){
            result.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(int i =0;i<nums.length;i++){
            if(included[nums[i]+10] == false){
                ds.add(nums[i]);
                included[nums[i]+10] = true;
                generatePerms(nums,included,ds,result);
                ds.remove(ds.size()-1);
                included[nums[i]+10] = false;
            }
        }
    }
}