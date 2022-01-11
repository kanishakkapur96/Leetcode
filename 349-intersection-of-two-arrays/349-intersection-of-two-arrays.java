class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1) return intersection(nums2,nums1);
        
        Arrays.sort(nums2); // nlogn
        Set<Integer> result = new HashSet<>();
        for(int i=0;i<n1;i++){
            if(Arrays.binarySearch(nums2,nums1[i])>=0){
                result.add(nums1[i]);
            }
        }
        int[] res = new int[result.size()];
        int cnt = 0;
        for(Integer i: result){
            res[cnt++] = i;
        }
        return res;
    }
}