class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1) return intersect(nums2,nums1);
        
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(Integer i: nums2){
            if(freq.containsKey(i)){
                freq.put(i,freq.get(i)+1);
            }else{
                freq.put(i,1);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(Integer i : nums1){
            if(freq.containsKey(i) && freq.get(i)!= 0){
                res.add(i);
                freq.put(i,freq.get(i)-1);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
        
    }
}