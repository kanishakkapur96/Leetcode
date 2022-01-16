class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        findSubsets(nums,0,new ArrayList<>(),result);
        return result;
    }
    void findSubsets(int[] nums,int index, List<Integer> ds, List<List<Integer>> result){
        
        if(index == nums.length){
            result.add(new ArrayList<Integer>(ds));
            return;
        }
        
        //Pick element
        ds.add(nums[index]);
        findSubsets(nums,index+1,ds,result);
        
        //Not pick
        ds.remove(ds.size()-1);
        findSubsets(nums,index+1,ds,result);
        
        /*
        result.add(new ArrayList<>(ds));
        for(int i = index;i<nums.length;i++){
            ds.add(nums[i]);
            findSubsets(nums,i+1,ds,result);
            ds.remove(ds.size()-1);
        }
        */
    }
}