class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer n : nums){
            if(!map.containsKey(n)){
                map.put(n,0);
            }
            
            map.put(n,map.get(n)+1);
        }
        
        
        
        generatePerms(nums,map,new ArrayList<Integer>(),result);
        return result;
    }
    
    void generatePerms(int[] nums, Map<Integer,Integer> map, List<Integer> ds, List<List<Integer>> result){
        // base case
        if(ds.size() == nums.length){
            result.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(Integer key: map.keySet()){
            
            if(map.get(key)!=0){
                ds.add(key);
                map.put(key, map.get(key)-1);
                generatePerms(nums,map,ds,result);
                ds.remove(ds.size()-1);
                map.put(key, map.get(key)+1);
            }
        }
    }
}