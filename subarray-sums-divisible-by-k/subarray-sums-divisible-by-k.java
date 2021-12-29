class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            int index = (sum%k + k)%k;
            count[index]++;
        }
        int ans = count[0];
        for(Integer i : count){
            int combinations = ( i * (i-1) ) /2;
            ans += combinations;
        }
        return ans;
    }
}