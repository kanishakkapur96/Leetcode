class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n+1];
        for(int i=0;i<=n;i++){
            nums[i] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(nums,n,k,1,new ArrayList<Integer>(),result);
        return result;
        
    }
    void generateCombinations(int[] nums,int n, int k,int index, List<Integer> ds, List<List<Integer>> result){
        // base case
        if(index == n+1 && ds.size()<k){
            return;
        }
        if(ds.size() == k){
            result.add(new ArrayList<Integer>(ds));
            return;
        }
        
        // Pick an element
        ds.add(nums[index]);
        generateCombinations(nums,n, k, index+1, ds, result);
        
        // Not pick
        ds.remove(ds.size()-1);
        generateCombinations(nums,n, k,index+1,ds,result);
        
        
    }
}