class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        generateSeq(nums,0,new ArrayList<Integer>(),result);
        
        return new ArrayList<>(result);
    }
    
    void generateSeq(int[] nums, int index, List<Integer> ds, Set<List<Integer>> result){
        if(ds.size()>=2){
            result.add(new ArrayList<Integer>(ds));
        }
        
        for(int i=index;i<nums.length;i++){
            
            if(ds.size() == 0 || nums[i]>=ds.get(ds.size()-1)){
                ds.add(nums[i]);
                generateSeq(nums,i+1,ds,result);
                ds.remove(ds.size()-1);
            }
        }
    }
}