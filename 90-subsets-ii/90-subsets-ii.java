class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result  = new ArrayList<>();
        findSubsets(nums,0,new ArrayList<>(),result);
        return result;
    }
    void findSubsets(int[] nums,int index, List<Integer> ds, List<List<Integer>> result){
        result.add(new ArrayList<>(ds));
        for(int i = index;i<nums.length;i++){
            if(i!=index && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(nums,i+1,ds,result);
            ds.remove(ds.size()-1);
        }
    }
}